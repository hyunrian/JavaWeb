package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ajaxTest1")
public class AjaxTest1 extends HttpServlet {

	// 비동기요청 사용해보기
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String param = request.getParameter("param");
		System.out.println("param: " + param);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
//		out.write("안녕하세요, 서버입니다.");
		String text = "안녕하세요, 서버입니다.";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
