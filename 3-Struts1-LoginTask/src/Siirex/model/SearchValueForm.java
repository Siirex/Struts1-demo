package Siirex.model;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.apache.struts.action.ActionForm;

import Siirex.dao.AppDao;

public class SearchValueForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String searchValue;
	private List<AccountDB> accountsFinded;
	
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public List<AccountDB> getAccountsFinded() {
		return accountsFinded;
	}
	public void setAccountsFinded(List<AccountDB> accountsFinded) {
		this.accountsFinded = accountsFinded;
	}
	
	public SearchValueForm() {
		// TODO Auto-generated constructor stub
	}
	
	public SearchValueForm(String searchValue, List<AccountDB> accountsFinded) {
		this.searchValue = searchValue;
		this.accountsFinded = accountsFinded;
	}

	public void searchAccounts() {
		
		AppDao dao = new AppDao();
		
		try {
			// Sau khi truyền giá trị nhập từ Form vào field "value"
			// Call DAO để tìm valid accounts dựa theo field "value"
			dao.findByUsername(this.searchValue);
			
			// Truyền valid accounts đã tìm được vào field "accountsFinded" để in ra JSP page!
			this.accountsFinded = dao.getListAccountDB();
			
		} catch (SQLException e) {
			Logger.getLogger(SearchValueForm.class.getName()).log(Level.SEVERE, null, e);
		} catch (NamingException e) {
			Logger.getLogger(SearchValueForm.class.getName()).log(Level.SEVERE, null, e);
		}
	}
}
