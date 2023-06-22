package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/member")
@SuppressWarnings("serial")
public class MemberServlet extends HttpServlet {
	
	MemberDao dao = MemberDao.getInstance();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");
		MemberVo vo = dao.selectByIdAndPwd(id, pwd);
		
		if (vo != null) { // 로그인에 성공한 경우
			HttpSession session = request.getSession(); // 요청이 바뀌어도 계속 남아있어야 하는 정보이기 때문에 세션에 저장
			session.setAttribute("loginVo", vo);
			out.println("<h1>로그인 성공</h1>");
			out.println("<a href='/pro09/showMember'>로그인한 사용자 정보</a>");
		} else { // 로그인 실패
			out.println("<h1>로그인 실패</h1>");
			out.println("<a href='/pro09/login3.html'>로그인 폼</a>");
			
		} 
		
	}
}
