package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청처리
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("userid: " + user_id + ", userpw: " + user_pw); 
		
		// 응답처리
		response.setContentType("text/html; charset=utf-8"); // 한글 깨지지 않게 설정. mime type 중 하나(필요할 때 검색해서 사용)
		PrintWriter writer = response.getWriter();
		writer.println("아이디: " + user_id + "<br>");
		writer.println("비밀번호: " + user_pw);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // post 방식에서는 한글 인코딩 방식 설정 필요
		doGet(request, response); // post / get 방식과 상관없이 동일한 작업 수행
	}

}
