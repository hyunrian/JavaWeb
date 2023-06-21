package sec01.ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/first2")
public class FirstServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println("FirstServlet id:" + id);
//		response.sendRedirect("second");
		RequestDispatcher dispatcher = request.getRequestDispatcher("second2");
		request.setAttribute("id", id);
		dispatcher.forward(request, response); 
		// forward : 페이지가 second2로 변경되지는 않으나 second의 코드는 실행됨(값 공유O)
		
		// 영역객체(유효범위) : page(페이지 내에서만), request, session, application(각각 살아있는 동안)
		// 영역객체와 파라미터를 헷갈리면 안됨
	}

}
