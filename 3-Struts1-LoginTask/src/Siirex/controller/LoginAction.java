package Siirex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Siirex.model.AccountForm;
import Siirex.model.AccountSessionForm;

public class LoginAction extends Action {

	private static final String SUCCESS = "success";
	private static final String FAIL = "failed";
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String url = FAIL;
		
		AccountForm accountForm = (AccountForm) form;
		// Vì sử dụng cấu trúc Service ngay trong Model/FormBean, nên:
		// 	- Vừa lấy được giá trị nhập từ Form
		//	- Vừa call DAO/Repository trực tiếp từ Model mà không cần thông qua Service ( không cần thiết phải tạo thêm đối tượng Service ở đây)
		boolean result = accountForm.checkLogin();

		if (result) {
			// Access Httpsessions for user | Expiration time (unexpired)
			HttpSession session = request.getSession(true);
			
			AccountSessionForm accountSession = new AccountSessionForm();
			accountSession.setUsername(accountForm.getUsername());
			accountSession.setPassword(accountForm.getPassword());
			
			// Setting bean/object (AccountSessionForm) into the session
			session.setAttribute("accountSession", accountSession);
			
			url = SUCCESS;
		}
		
		return mapping.findForward(url);
	}
}
