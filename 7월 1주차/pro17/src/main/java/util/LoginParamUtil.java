package util;

import javax.servlet.http.HttpServletRequest;

import sec03.ex01.LoginDto;

public class LoginParamUtil {

	public static LoginDto setData(HttpServletRequest request) {
		LoginDto dto = new LoginDto();

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String rememberId = request.getParameter("rememberId");
		
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setRememberId(rememberId);
		
		return dto;
	}
	
}
