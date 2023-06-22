package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/sess")
public class SessionTest extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); // PrintWriter보다 먼저 생성해야 적용됨
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String id = session.getId(); // 세션의 고유 아이디. 사용자 아이디와 상관 없음
		out.println("세션 아이디 : " + id + "<br>");
		
		long creationtime = session.getCreationTime();
		Date date = new Date(creationtime);
		out.println("세션 생성시간 : " + date + "<br>");
		
		long lastAccessedTime = session.getLastAccessedTime();
		Date date2 = new Date(lastAccessedTime);
		out.println("마지막 접속 시간 : " + date2 + "<br>");
		
		int interval = session.getMaxInactiveInterval();
		out.println("세션 유효 시간 : " + (interval / 60) + "분<br>");
		
		boolean b = session.isNew();
		if (b) { // 새로 생성된 세션이라면
			out.println("새로 생성된 세션입니다.<br>");
		}
		
		// 유효시간 30분 -> 5초 변경
//		session.setMaxInactiveInterval(5);
//		interval = session.getMaxInactiveInterval();
//		out.println("변경된 세션 유효 시간 : " + interval + "초<br>");
		
		// 세션 무효화하기 : 세션 삭제
		session.invalidate();
		
		
	}

}
