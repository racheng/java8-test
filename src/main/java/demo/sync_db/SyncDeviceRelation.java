package demo.sync_db;

import com.alibaba.fastjson.JSON;

import java.sql.*;
import java.util.Map;

/**
 * Created by leicheng on 16-10-24.
 */
public class SyncDeviceRelation {

		private static String USER_NAME = "haizhuan";
		private static String PASSWORD = "haizhuan_db2016!";
		private static String URL = "jdbc:mysql://114.55.218.21:3306/haizhuan";
//
//	private static String USER_NAME = "test";
//	private static String PASSWORD = "test";
//	private static String URL = "jdbc:mysql://192.168.0.248:3306/haizhuan";

	//	private static String selectSql = "SELECT device_id, device_extra FROM haizhuan.user_login_info WHERE id >= %s and id < %s";

	private static String insertSql = "insert ignore into haizhuan.antifraud_device_relation (device_id, type, id, create_time) values(?, ?, ?, ?);";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String query = "SELECT device_id, device_extra, login_time FROM haizhuan.user_login_info WHERE id >= %s and id < %s";

		Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		for (int i = 140000; i < 150000; i += 1000) {
			int j = i + 1000;
			String format = String.format(query, i, j);

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(format);

			PreparedStatement ps = connection.prepareStatement(insertSql);

			while (resultSet.next()) {
				String deviceId = resultSet.getString("device_id");
				String deviceExtra = resultSet.getString("device_extra");
				Timestamp loginDate = resultSet.getTimestamp("login_time");
				Map map = JSON.parseObject(deviceExtra, Map.class);
//				System.out.println(deviceExtra);
				String macAddress = (String) map.get("macAddress");
				String imei = (String) map.get("imei");
				String model = (String) map.get("model");
				String manufacturer = (String) map.get("manufacturer");
				String androidId = (String) map.get("androidId");
				ps.setString(1, deviceId);
				ps.setShort(2, DeviceRelationType.MAC);
				ps.setString(3, macAddress);
				ps.setTimestamp(4, loginDate);
				ps.addBatch();

				ps.setString(1, deviceId);
				ps.setShort(2, DeviceRelationType.IMEI);
				ps.setString(3, imei);
				ps.setTimestamp(4, loginDate);
				ps.addBatch();

				ps.setString(1, deviceId);
				ps.setShort(2, DeviceRelationType.MODEL);
				ps.setString(3, model);
				ps.setTimestamp(4, loginDate);
				ps.addBatch();

				ps.setString(1, deviceId);
				ps.setShort(2, DeviceRelationType.MANUFACTURE);
				ps.setString(3, manufacturer);
				ps.setTimestamp(4, loginDate);
				ps.addBatch();

				ps.setString(1, deviceId);
				ps.setShort(2, DeviceRelationType.ANDROIDID);
				ps.setString(3, androidId);
				ps.setTimestamp(4, loginDate);
				ps.addBatch();

			}
			System.out.println("sync " + i + "-" + j + "records....");
			ps.executeBatch();
		}
		connection.close();
	}
}
