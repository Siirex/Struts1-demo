package Siirex.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {

	public static Connection getConnection() throws Exception {
		
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/strutsdb", "postgres", "304304");
			
			// https://www.tutorialspoint.com/postgresql/postgresql_java.htm
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
