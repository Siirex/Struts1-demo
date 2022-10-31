package Siirex.Model;

import org.apache.struts.action.ActionForm;

public class UserFormNonValidate extends ActionForm {

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
	
	public UserFormNonValidate() {
		// TODO Auto-generated constructor stub
	}

	public UserFormNonValidate(Long id, String name, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
}
