package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginRunServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if (id.equals("hong") && pw.equals("1234")) {
			out.println("로그인 성공");
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(1000);
			response.addCookie(cookie);
		} else {
			out.println("<script>alert('로그인 실패. 로그인 화면으로 이동합니다.');"
					+ "	location.href='/test01/loginForm;'"
					+ "	</script>");
			
		}
		
	}

	
	
}
