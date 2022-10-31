package Siirex.model;

import org.apache.struts.action.ActionForm;

public class AccountSessionForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String username;
	private String password;
	private String lastmsg;
	
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
	public String getLastmsg() {
		return lastmsg;
	}
	public void setLastmsg(String lastmsg) {
		this.lastmsg = lastmsg;
	}
	
}
