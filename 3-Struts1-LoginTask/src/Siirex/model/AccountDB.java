package Siirex.model;

public class AccountDB {

	private String username;
	private String password;
	private boolean isAdmin;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public AccountDB() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountDB(String username, String password, boolean isAdmin) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
	}
}
