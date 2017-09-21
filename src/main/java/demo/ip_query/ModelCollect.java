package demo.ip_query;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leicheng on 16-11-14.
 */
public class ModelCollect {

	public static final String SQL_URL = "jdbc:mysql://192.168.0.248:3306/apollo";
	public static final String SQL_USER = "test";
	public static final String SQL_PW = "test";

	public static final String SERVICE_SQL_URL_LINE = "jdbc:mysql://10.144.134.60:8066/hsp_clog";
	public static final String SERVICE_SQL_USER_LINE = "hspcobar";
	public static final String SERVICE_SQL_PASS_LINE = "55huaQianV2!";

	//	private static final String url = "http://ip.taobao.com/service/getIpInfo.php?ip=%s";
	private static final String url = "http://apis.juhe.cn/ip/ip2addr?key=d0930b741a71146ac7ebf456da29215d&ip=%s";

	public static void main(String[] args) throws IOException {

		String[] ipList = new String[3000];
		File file = new File("/home/leicheng/up1000");
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		int line = 0;

		// 一次读入一行，直到读入null为文件结束
		int index = 0;
		while ((tempString = reader.readLine()) != null) {
			ipList[index] = tempString;
			index++;
			//			if (index == 10) {
			//				excute(ipList);
			////				System.out.println(JSON.toJSONString(ipList));
			//				index = 0;
			//			}

		}
		HashMap<String, List<String>> modelMap = new HashMap<>();
		int num = 0;
		for (String s : ipList) {
			System.out.println(num++);
			if (s == null || s.equals("")) {
				continue;
			}
			//				Thread.sleep(10L);
			String[] split = s.split(",");
			String brand = split[0];
			String model = split[1];

			List<String> modelList = modelMap.get(brand);
			if (modelList == null) {
				modelList = new ArrayList<>();
			}
			modelList.add(model);
			modelMap.put(brand, modelList);
		}

		System.out.println(index);

		excute(modelMap);

	}

	private static void excute(Map<String, List<String>> modelMap) {

		String insert = "insert into directional_attribute(id, parent_id, type, code, name) values (?, ?, ?, ?, ?)";

		Connection insertConnection = null;
		try {
			insertConnection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PW);
			PreparedStatement insertPs = insertConnection.prepareStatement(insert);
			int count = 20;
			for (Map.Entry<String, List<String>> entry : modelMap.entrySet()) {
				try {
					String brand = entry.getKey();
					int brandId = ++count;
					System.out.println(brandId);
					insertPs.setInt(1, brandId);
					insertPs.setInt(2, 0);
					insertPs.setInt(3, 1);

					insertPs.setString(4, brand);
					insertPs.setString(5, brand);
					insertPs.addBatch();
					for (String model : entry.getValue()) {
						try {
							int modelId = ++count;
							System.out.println(modelId);
							insertPs.setInt(1, modelId);
							insertPs.setInt(2, brandId);
							insertPs.setInt(3, 2);
							insertPs.setString(4, model);
							insertPs.setString(5, model);
							insertPs.addBatch();
							if (count % 100 <= 1) {
								insertPs.executeBatch();
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					if (count % 100 <= 1) {
						insertPs.executeBatch();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			insertPs.close();
			insertConnection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
