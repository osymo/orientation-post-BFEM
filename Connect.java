package ClasseDeRequete;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	private static Connection conn;
	private static String url = "jdbc:mysql://localhost:3306/orientation";
	private static String user = "root";
	private static String password = "";

	public static Connection connection() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}