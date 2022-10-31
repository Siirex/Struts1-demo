package Siirex.Controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import Siirex.Model.UserDB;
import Siirex.Model.UserForm;
import Siirex.Service.UserService;

public class UserActions extends MappingDispatchAction {
	
	/**
	 * Method for Home page
	 */
	public ActionForward homePage(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response
	) throws SQLException, Exception {
		
		UserService service = new UserService();
		List<UserDB> users = service.getAllUser();
		
		// Mỗi khi request đến, ta gán đối tượng "users" cho attribute "allUser"
		// Attribute này sẽ được sử dụng trong JSP page - khi Server response về cho Client
		request.setAttribute("allUser", users);
		
		return mapping.findForward("homePage");
	}
	
	/**
	 * Method for Register page
	 */
	public ActionForward registerPage(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response
	) throws SQLException, Exception {

		return mapping.findForward("registerPage");
	}
	
	/**
	 * Method for Register page (after submit --> export messages)
	 */
	public ActionForward registerCheckPage(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response
	) throws SQLException, Exception {
		
		UserForm userForm = (UserForm) form;
		
		UserService service = new UserService();
		UserDB userDB = new UserDB(service.getMaxId() + 1L, userForm.getName(), userForm.getAge());
		
		int result = service.registerUser(userDB);
		
		if (result <= 0) {
			request.setAttribute("message", "Can't register User!");
		} else {
			request.setAttribute("message", "Register new User successfully!");
		}
		
		return mapping.findForward("registerCheckPage");
	}
	
	/**
	 * Method for get user process (after to update/edit user)
	 */
	public ActionForward getUserPage(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response
	) throws SQLException, Exception {
		
		// Khi Client click vào "Update", action "getUser.do" sẽ được call!
		// Request "/getUser.do?userId=2" sẽ đến App Server
		// Lúc này ta sẽ bắt Parameter "userId" từ request!!!
		int userId = Integer.valueOf(request.getParameter("userId"));
		
		System.out.println("> UserID sent up: " + userId);
		
		UserService service = new UserService();
		UserDB userDB = service.getUserById(userId);		
		UserForm userForm = new UserForm(userDB.getId(), userDB.getName(), userDB.getAge());

		request.setAttribute("user", userForm);
		
		return mapping.findForward("getUserPage");
	}
	
	/**
	 * Method for Update page
	 */
	public ActionForward updateUserPage(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response
	) throws SQLException, Exception {
		
		UserForm userForm = (UserForm) form;
		
		System.out.println("> Name updated: " + userForm.getId());
		System.out.println("> Name updated: " + userForm.getName());
		System.out.println("> Name updated: " + userForm.getAge());
		
		UserService service = new UserService();
		UserDB userDB = new UserDB(userForm.getId(), userForm.getName(), userForm.getAge());
		
		int result = service.updateUser(userDB);
		
		if (result <= 0) {
			request.setAttribute("message", "Can't update user!");
		} else {
			request.setAttribute("message", "Update user successfully!");
		}
		
		service = new UserService(); // ?
		List<UserDB> users = service.getAllUser();
		request.setAttribute("allUser", users);
		
		return mapping.findForward("updateUserPage");
	}
	
	/**
	 * Method for Delete process
	 */
	public ActionForward deleteUserPage(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response
	) throws SQLException, Exception {
		
		// Path: /deleteUserPage.do?userId=3
		int userId = Integer.valueOf(request.getParameter("userId"));
		
		UserService service = new UserService();
		
		int result = service.deleteUser(userId);
		
		if (result <= 0) {
			request.setAttribute("message", "Can't delete user!");
		} else {
			request.setAttribute("message", "Delete user successfully!");
		}
		
		service = new UserService(); // ?
		List<UserDB> users = service.getAllUser();
		request.setAttribute("allUser", users);
		
		return mapping.findForward("deleteUserPage");
	}
}
