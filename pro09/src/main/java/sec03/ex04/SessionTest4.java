package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login4")
public class SessionTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		// 로그인 성공이라 가정
		
		if (session.isNew()) { // 처음 생성된 세션인 경우
			// 세션영역에 login_id라는 이름으로 사용자의 아이디를 저장함
			// session은 request보다 영역이 큼(이 코드에서 session이 아니라 request로 작성하면 attribute 활용 불가) 
			session.setAttribute("login_id", id);
			out.print("<a href='/pro09/login4'>확인하러 가기</a>");
		} else {
			String login_id = (String)session.getAttribute("login_id");
			out.print("<h1>" + login_id + "님 반갑습니다.</h1>"); 
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
