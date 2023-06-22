package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set2")
public class SetCookieValue2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie cookie = new Cookie("sessionCookie", "sessionCookie"); // 유효하지 않은 문자 에러 발생하여 인코딩해줌
		cookie.setMaxAge(-1); // 음수로 설정하면 세션쿠키로 설정됨(브라우저 종료 시 자동 삭제)
		response.setContentType("text/html;charset=utf-8"); // 오타 주의!(test라고 썼음) 브라우저가 인식하지 못하는 mime-type이면 다운로드처리 됨 
		response.addCookie(cookie);
		PrintWriter out = response.getWriter();
		out.println("<h1>쿠키생성 완료</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
