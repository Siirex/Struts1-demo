package Siirex.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Siirex.DAO.DatabaseConnect;
import Siirex.Model.UserDB;

public class UserRepository {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public UserRepository() {
		try {
			this.connection = DatabaseConnect.getConnection();
			System.out.println("> Connection = " + this.connection);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> Don't connect to DB!");
		}
	}

	/**
	 * Method for save Uesr data in database
	 */
	public int registerUser(UserDB userDB) throws Exception {
		
		int i = 0;
		
		try {
			String sql = "INSERT INTO t_user VALUES (?,?,?)";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			System.out.println("> Register user has ID: " + userDB.getId());
			
			ps.setLong(1, userDB.getId());
			ps.setString(2, userDB.getName());
			ps.setInt(3, userDB.getAge());
			
			// executeUpdate() execute command INSERT, UPDATE, DELETE
			// Trả về 0 nếu SQL statements không trả về gì?
			i = ps.executeUpdate();
			
			return i;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> Register process error!");
			return i;
			
		} finally {
			if (this.connection != null) {
				this.connection.close();
			}
		}
	}
	
	/**
	 * Method for get all Uesr data in database
	 */
	public List<UserDB> listAllUser() throws SQLException, Exception {
		
		ResultSet rs = null;
		
		List<UserDB> users = new ArrayList<UserDB>();
		
		try {
			String sql = "SELECT * FROM t_user";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			// executeQuery() execute command SELECT, ...
			rs = ps.executeQuery();
			
			// true if the new current row is valid
			// false if there are no more rows 
			while (rs.next()) {
				UserDB userDB = new UserDB(rs.getLong(1), rs.getString(2), rs.getInt(3));
				users.add(userDB);
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (this.connection != null) {
				this.connection.close();
			}
		}
		
		return users;
	}
	
	/**
	 * Method for get User data (by ID) in database
	 */
	public UserDB getUserById(int id) throws SQLException, Exception {
		
		ResultSet rs = null;
		
		UserDB userDB = null;

		try {
			String sql = "SELECT * FROM t_user WHERE t_user.id=?";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ps.setLong(1, id);

			rs = ps.executeQuery();
			
			if(rs.next()) {
				userDB = new UserDB(rs.getLong(1), rs.getString(2), rs.getInt(3));
			}

			return userDB;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> getUserById() process error!");
			return userDB;
			
		} finally {
			if (this.connection != null) {
				this.connection.close();
			}
		}
	}
	
	/**
	 * Method for delete Uesr data in database
	 */
	public int deleteUser(int id) throws Exception {
		
		int i = 0;
		
		try {
			String sql = "DELETE FROM t_user WHERE t_user.id=?";
			PreparedStatement ps = this.connection.prepareStatement(sql);

			ps.setLong(1, id);
			
			// executeUpdate() execute command INSERT, UPDATE, DELETE
			i = ps.executeUpdate();
			
			return i;
			
		} catch (Exception e) {
			e.printStackTrace();
			return i;
			
		} finally {
			if (this.connection != null) {
				this.connection.close();
			}
		}
	}
	
	/**
	 * Method for update Uesr data in database
	 */
	public int updateUser(UserDB userDB) throws Exception {
		
		int i = 0;
		
		try {
			String sql = "UPDATE t_user SET name=?, age=? WHERE t_user.id=?";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			ps.setLong(3, userDB.getId());
			ps.setString(1, userDB.getName());
			ps.setInt(2, userDB.getAge());
			
			// executeUpdate() execute command INSERT, UPDATE, DELETE
			i = ps.executeUpdate();
			
			return i;
			
		} catch (Exception e) {
			e.printStackTrace();
			return i;
			
		} finally {
			if (this.connection != null) {
				this.connection.close();
			}
		}
	}
	
	public Long getMaxId() throws Exception {
		
		Long maxId = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT coalesce(max(id), 0) FROM t_user";
			PreparedStatement ps = this.connection.prepareStatement(sql);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				maxId = rs.getLong(1);
			}
			
			return maxId;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> getMaxId() process failure!");
			
		} 
		/**
		 * Vì method này được thực thi trước trong cùng 1 transaction 
		 * với method registerUser(), nên ở đây ta chưa thể close connection!!!
		 */
		
		return null;
	}
}
