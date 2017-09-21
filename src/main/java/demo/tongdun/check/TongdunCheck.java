package demo.tongdun.check;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leicheng on 17-7-10.
 */
public class TongdunCheck {

	public static final String SQL_URL = "jdbc:mysql://rm-bp15v5js79v4o5295o.mysql.rds.aliyuncs.com:3306/open_service";
	public static final String SQL_USER = "openservice";
	public static final String SQL_PW = "openservice_db2017!";

	private static final String query = "select user_id, decision from tongdun_risk_info where app_id = 'huisuoping' and user_id = ?";

	public static void main(String[] args) {
		ArrayList<String> userList = new ArrayList<>();
		File file = new File("/home/leicheng/work/user.txt");
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader(file));
			int index = 0;
			String tempString;

			while ((tempString = bf.readLine()) != null) {
				index++;
				userList.add(tempString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection connection = null;
		HashMap<String, String> userStateMap = new HashMap<>();

		try {
			connection = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PW);
			PreparedStatement statement = connection.prepareStatement(query);
			for (String userId : userList) {
				statement.setString(1, userId);
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String user_id = resultSet.getString("user_id");
					String decision = resultSet.getString("decision");
					userStateMap.put(user_id, decision);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		File resultFile = new File("/home/leicheng/work/result.txt");
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile));

			for (Map.Entry<String, String> entry : userStateMap.entrySet()) {
				bufferedWriter.write(entry.getKey() + "," + entry.getValue());
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
