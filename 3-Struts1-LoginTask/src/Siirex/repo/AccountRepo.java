package Siirex.repo;

import java.sql.Connection;

import Siirex.dao.db.DbConnect;

public class AccountRepo {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public AccountRepo() {
		try {
			this.connection = DbConnect.getConnection();
			System.out.println("> Connection = " + this.connection);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> Don't connect to DB!");
		}
	}
}
