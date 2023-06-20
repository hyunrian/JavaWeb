package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet5() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB - hong/1234로 되어있다고 가정
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String result = "";
		if (user_id.equals("hong") && user_pw.equals("1234")) {
			result = "success";
		} else {
			result = "fail";
		}
		
		PrintWriter out = response.getWriter();
		out.println(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post request");
		request.setCharacterEncoding("utf-8"); // post요청에 대한 한글 처리
		doGet(request, response);
	}

}
