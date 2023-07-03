package util;

import javax.servlet.http.HttpServletRequest;

import sec02.ex01.MemberVo;

public class MemberParamUtil {

	public static MemberVo setData(HttpServletRequest request) {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		MemberVo vo = new MemberVo(id, pwd, name, email);
		return vo;
	}
	
	
}
