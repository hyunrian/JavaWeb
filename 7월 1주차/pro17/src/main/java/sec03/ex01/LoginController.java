package sec03.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.BoardParamUtil;
import util.LoginParamUtil;

@SuppressWarnings("serial")
@WebServlet("/login/*") 
public class LoginController extends HttpServlet { 
	
	private final String PREFIX = "/WEB-INF/views/"; 
	private final String POSTFIX = ".jsp"; 
	private LoginService loginService = LoginService.getInstance();

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		HttpSession session = request.getSession();
		
		LoginDto dto = null;
		String nextPage = "";
		
		switch (pathInfo) {
		case "/loginForm":
			nextPage = "login/loginForm";
			break;
		case "/loginRun":
			dto = LoginParamUtil.setData(request);
			System.out.println("loginDto:" + dto);
			boolean loginResult = loginService.login(dto);
			session.setAttribute("loginResult", loginResult);
			if (loginResult == true) {
				session.setAttribute("loginId", dto.getId());
				// 아이디저장 체크 시 활용할 쿠키 생성
				if (dto.getRememberId() != null &&
						dto.getRememberId().equals("on")) {
					Cookie cookie = new Cookie("loginId", dto.getId()); 
					cookie.setMaxAge(60 * 60 * 24 * 7); // 일주일
					response.addCookie(cookie);
				}
				nextPage = "redirect:/board/getList";
			} else {
				nextPage = "redirect:/login/loginForm";
			}
			break;
		case "/logout":
			session.invalidate(); // 현재 세션 무효화 -> 로그아웃됨
			nextPage = "redirect:/login/loginForm";
			break;
		}
		
		if (nextPage.startsWith("redirect:")) { // redirect를 하는 경우
			response.sendRedirect(
					nextPage.substring(nextPage.indexOf("/"))); // redirect:/ 이후의 문자열 구해서 redirect 처리
		} else { // forward를 하는 경우
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(PREFIX + nextPage + POSTFIX);
			dispatcher.forward(request, response); // view쪽에 list를 넘겨줌
		}
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
