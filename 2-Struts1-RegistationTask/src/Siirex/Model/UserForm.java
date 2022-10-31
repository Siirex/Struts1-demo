package Siirex.Model;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UserForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private int age;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	
	public UserForm() {
		// TODO Auto-generated constructor stub
	}
	
	public UserForm(Long id, String name, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	
	@Override
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.name = "test";
		this.age = 18;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = new ActionErrors();
		
		if (getName() == null || getName().length() < 1) {
			errors.add("name", new ActionMessage("name.not.entered"));
		}
		
		if (getAge() < 18) {
			errors.add("age", new ActionMessage("age.not.entered"));
		}
		
		return errors;
	}
}
