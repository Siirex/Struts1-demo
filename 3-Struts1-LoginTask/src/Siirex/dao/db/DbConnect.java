package Siirex.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

	// File context.xml đã thay thế!!!
	public static Connection getConnection() throws Exception {
		
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/StrutsLoginTaskDB", "postgres", "304304");

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
