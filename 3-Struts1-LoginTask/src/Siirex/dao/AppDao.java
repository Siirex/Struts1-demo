package Siirex.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import Siirex.dao.db.DbUtilities;
import Siirex.model.AccountDB;

public class AppDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Login progress
	 */
	
	public boolean checkLogin(String username, String password) throws SQLException, NamingException {
		
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connect = DbUtilities.makeConnection();
			System.out.println("> Connection = " + connect);
			
			if (connect != null) {
				
				String sql = "SELECT * FROM t_account AS x WHERE x.username=? AND x.password=?";
				ps = connect.prepareStatement(sql);
				
				ps.setString(1, username);
				ps.setString(2, password);
				
				rs = ps.executeQuery();
				if (rs.next()) {
					return true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> checkLogin() DAO process error!");
			
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
		return false;
	}
	
	/**
	 * Search progress
	 */
	
	private List<AccountDB> listAccountDB;

	public List<AccountDB> getListAccountDB() {
		return listAccountDB;
	}
	public void setListAccountDB(List<AccountDB> listAccountDB) {
		this.listAccountDB = listAccountDB;
	}
	
	public void findByUsername(String value) throws SQLException, NamingException {
		
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connect = DbUtilities.makeConnection();
			
			if (connect != null) {
				
				String sql = "SELECT * FROM t_account AS x WHERE x.username LIKE ?";
				ps = connect.prepareStatement(sql);
				
				ps.setString(1, value);

				rs = ps.executeQuery();
				
				while (rs.next()) {
					
					String username = rs.getString("username");
					String password = rs.getString("password");
					boolean isAdmin = rs.getBoolean("isAdmin");
					
					AccountDB dto = new AccountDB(username, password, isAdmin);
					
					if (this.listAccountDB == null) {
						
						this.listAccountDB = new ArrayList<AccountDB>();
					}
					this.listAccountDB.add(dto);
				}
				
				System.out.println("> listAccountDB: " + listAccountDB);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> findByUsername() DAO process error!");
			
		} finally {
			if (connect != null) {
				connect.close();
			}
		}
	}

}
