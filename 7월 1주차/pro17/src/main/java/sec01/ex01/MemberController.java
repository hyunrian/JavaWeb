package sec01.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mem.do")
public class MemberController extends HttpServlet { // 요청 처리는 서블릿에서 작업
	
	private MemberService memberService = MemberService.getInstance();

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		List<MemberVo> list = memberService.listMembers();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(
				"/WEB-INF/views/test01/listMembers.jsp");
		dispatcher.forward(request, response); // view쪽에 list를 넘겨줌
		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
