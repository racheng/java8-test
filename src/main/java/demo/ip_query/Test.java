package demo.ip_query;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huadongmedia.common.util.NetworkUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by leicheng on 16-11-14.
 */
public class Test {

	public static final String SQL_URL = "jdbc:mysql://192.168.0.248:3306/apollo";
	public static final String SQL_USER = "test";
	public static final String SQL_PW = "test";

	public static final String SERVICE_SQL_URL_LINE = "jdbc:mysql://10.144.134.60:8066/hsp_clog";
	public static final String SERVICE_SQL_USER_LINE = "hspcobar";
	public static final String SERVICE_SQL_PASS_LINE = "55huaQianV2!";

//	private static final String url = "http://ip.taobao.com/service/getIpInfo.php?ip=%s";
	private static final String url = "http://apis.juhe.cn/ip/ip2addr?key=d0930b741a71146ac7ebf456da29215d&ip=%s";

	public static void main(String[] args) throws IOException {

		String[] ipList = new String[1556020];
		File file = new File("/home/leicheng/ip.txt");
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
		System.out.println(index);
		System.out.println(ipList[1556015]);

		excute(ipList);

	}

	private static void excute(String[] ipList) {

		String insert = "insert into ip_area(ip, area) values (?, ?)";

		Connection insertConnection = null;
		try {
			insertConnection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PW);
			PreparedStatement insertPs = insertConnection.prepareStatement(insert);
			int count = 0;
			for (String ip : ipList) {
				Thread.sleep(10L);
				try {
					String response = NetworkUtil.get(String.format(url, ip));

					System.out.println(count + response);

					JSONObject responseObj = JSON.parseObject(response);

					JSONObject resultObj = responseObj.getJSONObject("result");

					String area = resultObj.getString("area");

					insertPs.setString(1, ip);
					insertPs.setString(2, area);
					insertPs.addBatch();
					count++;
					if (count == 100) {
						insertPs.executeBatch();
						count = 0;
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
