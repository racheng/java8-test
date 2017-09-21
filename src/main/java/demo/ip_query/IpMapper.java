package demo.ip_query;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by leicheng on 17-6-26.
 */
public class IpMapper {

	public static final String SQL_URL = "jdbc:mysql://192.168.0.248:3306/apollo";
	public static final String SQL_USER = "test";
	public static final String SQL_PW = "test";

	public static final String query = "select * from ip_area";

	public static void main(String[] args) throws IOException {

		HashMap<String, String> ipAreaMap = new HashMap<>();

		System.out.println("start query!");
		//		Connection connection = null;
		//		try {
		//			connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PW);
		//			Statement statement = connection.createStatement();
		//			ResultSet resultSet = statement.executeQuery(query);
		//			boolean next = resultSet.next();
		//			while (next) {
		//				String ip = resultSet.getString("ip");
		//				String area = resultSet.getString("area");
		//				ipAreaMap.put(ip, area);
		//			}
		//
		//
		//		} catch (SQLException e) {
		//			e.printStackTrace();
		//		}

		File file = new File("/home/leicheng/Desktop/ip_area.txt");
		BufferedReader bf = new BufferedReader(new FileReader(file));
		int index = 0;
		String tempString;
		while ((tempString = bf.readLine()) != null) {
			index++;
			String[] split = tempString.split(",");
			if (split.length == 2) {
				ipAreaMap.put(split[0], split[1]);
			}
		}
		System.out.println("total count:" + index);

		System.out.println("start match region!");

		Map<String, Integer> regionMap = Region.getRegionMap();
		HashMap<String, Integer> ipRegionMap = new HashMap<>();
		for (Map.Entry<String, String> entry : ipAreaMap.entrySet()) {
			String area = entry.getValue();
			Integer regionCode = null;
			for (Map.Entry<String, Integer> regionEntry : regionMap.entrySet()) {
				String region = regionEntry.getKey();
				if (area.contains(region)) {
					regionCode = regionEntry.getValue();
					break;
				}
			}
			ipRegionMap.put(entry.getKey(), regionCode);
		}

		System.out.println("start check unmatched area!");

		Map<String, Integer> provinceMap = Region.getProvinceMap();
		HashSet<String> unMatchedArea = new HashSet<>();
		for (Map.Entry<String, Integer> entry : ipRegionMap.entrySet()) {
			if (entry.getValue() == null) {
				String area = ipAreaMap.get(entry.getKey());
				Integer regionCode = null;
				for (Map.Entry<String, Integer> provinceEntry : provinceMap.entrySet()) {
					String province = provinceEntry.getKey();
					if (area.contains(province)) {
						regionCode = provinceEntry.getValue();
						entry.setValue(regionCode);
						break;
					}
				}
			}
		}

		for (Map.Entry<String, Integer> entry : ipRegionMap.entrySet()) {
			if (entry.getValue() == null) {
				String area = ipAreaMap.get(entry.getKey());
				unMatchedArea.add(area);
			}
		}

		File outFile = new File("/home/leicheng/Desktop/unmath_area.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
		for (String s : unMatchedArea) {
			System.out.println(s);
			bw.write(s);
			bw.newLine();
		}
		bw.close();

		File ipRegionFile = new File("/home/leicheng/Desktop/ip_region_code.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ipRegionFile));
		for (Map.Entry<String, Integer> entry : ipRegionMap.entrySet()) {
			String ip = entry.getKey();
			Integer regionCode = entry.getValue();
			String regionDesc = ipAreaMap.get(ip);
			if (ip != null && regionCode != null) {
				String[] ipSplit = ip.split("\\.");
				int ipInt = 9999999;
				//				if (ipSplit.length == 4) {
				ipInt = Integer.parseInt(ipSplit[0]) * 256 * 256 * 256 + Integer.parseInt(ipSplit[1]) * 256 * 256
						+ Integer.parseInt(ipSplit[2]) * 256 + Integer.parseInt(ipSplit[3]);
				//				}
				bufferedWriter.write(ipInt + "," + ip + "," + regionCode + "," + regionDesc);
				bufferedWriter.newLine();
			}
		}
		bufferedWriter.close();
	}

}
