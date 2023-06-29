package ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	// 아이디 hong, 비번 1234 유저 데이터가 있다고 가정하고 최초 로그인 이후 브라우저 재실행했을 때 아이디에 hong이 남아있도록 설정
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String holder = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie aCookie : cookies) {
			String name = aCookie.getName();
			if (name.equals("id")) {
				holder = aCookie.getValue();
				break;
			}
		}
		
		String html = "";
		html += "<form action='/test01/loginRun' method='post'>"
				+ "아이디 : <input type='text' name='id' value='"+ holder +"'><br>"
				+ "비밀번호 : <input type='password' name='pw'><br>"
				+ "<button>로그인</button>"
				+ "</form>";
		
		out.println(html);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

	
}
