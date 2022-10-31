package Siirex.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import Siirex.dao.AppDao;

public class AccountForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
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
	
	public AccountForm() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.username = "";
		this.password = "";
	}
	
	public AccountForm(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * - Sử dụng cấu trúc Service ngay trong Model !!!
	 * - Dùng phương pháp này sẽ làm cho quy trình ở Controller (Actions) trở nên dễ triển khai hơn!
	 */
	public boolean checkLogin() {
		
		AppDao dao = new AppDao();
		
		try {
			boolean result = dao.checkLogin(username, password);
			return result;
			
		} catch (SQLException e) {
			Logger.getLogger(AccountForm.class.getName()).log(Level.SEVERE, null, e);
		} catch (NamingException e) {
			Logger.getLogger(AccountForm.class.getName()).log(Level.SEVERE, null, e);
		}
		
		return false;
	}
	
}
