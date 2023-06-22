package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginForm")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 아이디 hong, 비번 1234 유저 데이터가 있다고 가정하고 최초 로그인 이후 브라우저 재실행했을 때 아이디에 hong이 남아있도록 설정
		
		Cookie[] cookies = request.getCookies();
		String userId = "";

		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if (name.equals("userId")) {
				userId = cookie.getValue();
				System.out.println("id:" + userId);
				break;
			}
		}
		
		String html = "";
		html += "<form action='loginRun' method='post'>"
				+ "아이디 : <input type='text' name='id' value="+ userId +"><br>"
				+ "비밀번호 : <input type='password' name='pw'><br><br>"
				+ "<button>로그인</button>"
				+ "</form>";
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
