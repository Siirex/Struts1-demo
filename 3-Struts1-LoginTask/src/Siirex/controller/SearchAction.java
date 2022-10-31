package Siirex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Siirex.model.SearchValueForm;

public class SearchAction extends Action {

	private static final String SUCCESS = "success";
	private static final String FAIL = "failed";
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		SearchValueForm form2 = (SearchValueForm) form;

		System.out.println("> Value: " + form2.getSearchValue());
		
		try {
			form2.searchAccounts();
			
			if (form2.getAccountsFinded() != null) {
				
				request.setAttribute("listAccounts", form2.getAccountsFinded());
				
				return mapping.findForward(SUCCESS);
			}
		} catch (Exception e) {
			System.out.println("> Error search progress!");
		}
		return mapping.findForward(FAIL);
	}
}
