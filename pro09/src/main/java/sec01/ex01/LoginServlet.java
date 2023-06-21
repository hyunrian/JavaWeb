package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		String hp = request.getParameter("hp");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String html = "";
		html += "<html>"
				+ "<body>"
				+ "안녕하세요<br>"
				+ "로그인하셨습니다.<br><br>"
				+ "아이디: " + id + "<br>" 
				+ "비밀번호: " + pw + "<br>" 
				+ "주소: " + addr + "<br>" 
				+ "이메일: " + email + "<br>" 
				+ "폰번호: " + hp + "<br>" 
				+ "<a href='/pro09/second?id="+ id + "&pw=" + pw + "&addr= " + addr + "'>두번째 서블릿으로 가기</a>" 
				+ "</body>"
				+ "</html>";
		out.print(html);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
