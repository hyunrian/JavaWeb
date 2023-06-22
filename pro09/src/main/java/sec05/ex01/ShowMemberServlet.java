package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/showMember")
public class ShowMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("loginVo");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (vo != null) { // 정상적으로 로그인을 했을 경우
			out.println("아이디 : " + vo.getId() + "<br>");
			out.println("비밀번호 : " + vo.getPwd() + "<br>");
			out.println("이름 : " + vo.getName() + "<br>");
			out.println("이메일 : " + vo.getEmail() + "<br>");
			out.println("가입일 : " + vo.getJoindate() + "<br>");
			out.println("<a href='/pro09/logout'>로그아웃</a><br>");
		} else { // 로그인을 하지 않고 페이지에 접근한 경우
			out.println("<script>alert('비정상적인 접근입니다.');"
					+ "	location.href = '/pro09/login3.html';"
					+ "</script>");
			
			// response.sendRedirect("/pro09/login3.html"); //script와 같이 사용하면 redirect되면서 script 코드가 작동하지 않음
		}
	}

}
