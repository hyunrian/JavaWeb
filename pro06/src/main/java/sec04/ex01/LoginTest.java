package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		response.setContentType("text/html;charset=utf-8"); // text/html이 없으면 아래 html 코드가 문자로만 인식됨
		PrintWriter out = response.getWriter();
		String text = "";
		
		if (user_id.equals("")) {
			text = "아이디를 입력하세요!!!<br>"
					+ "<a href='/pro06/test01/login.html'>로그인창으로 이동</a>";
		} else if (user_id.equals("admin")){
			text = "<h1>관리자로 로그인 하셨습니다!!<h1>"
					+ "<button>회원정보 수정하기</button> <button>회원정보 삭제하기</button>";
		} else {
			text = user_id + " 님!! 로그인 하셨습니다.";
		}
		out.println(text);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
