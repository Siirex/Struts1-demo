package Siirex.dao.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// http://www.kieutrongkhanh.net/2016/08/tao-ket-noi-ong-en-db-trong-mo-hinh-mvc.html

public class DbUtilities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Connection makeConnection() throws NamingException, SQLException {
		
		Context context = new InitialContext();
		Context tomcatContext = (Context) context.lookup("java:comp/env");
		
		DataSource ds = (DataSource) tomcatContext.lookup("loginTaskDB");
		System.out.println("> DataSource: " + ds);
		
		Connection connect = ds.getConnection();
		
		return connect;
	}
}
