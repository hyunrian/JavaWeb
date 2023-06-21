package sec01.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String id = request.getParameter("id");
		String id = (String)request.getAttribute("id"); // null. 값이 공유되지 않음
		System.out.println("SecondServlet id:" + id); // redirect - firstservlet과 정보 공유 하지 않음
		
	}

}
