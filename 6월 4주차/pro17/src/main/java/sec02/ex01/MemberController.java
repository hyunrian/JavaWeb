package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/member/*") // 경로가 /member/xxx 로 들어오면 모든 요청을 여기서 처리. 
						

public class MemberController extends HttpServlet { // 요청 처리는 서블릿에서 작업
	
	private MemberService memberService = MemberService.getInstance();
	private final String PREFIX = "/WEB-INF/views/"; 
	private final String POSTFIX = ".jsp"; 

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 경로 정보 얻기
		String pathInfo = request.getPathInfo(); 
		// 등록되어있지 않은 경로여도 url에 입력하면 /member/xxx -> /xxx로 경로를 얻을 수 있음
		System.out.println("pathInfo: "+pathInfo);
		
		String nextPage = "";
		
		switch (pathInfo) {
		case "/listMembers" : // 회원 목록 조회
			List<MemberVo> list = memberService.listMembers();
			request.setAttribute("list", list);
			nextPage = "test01/listMembers";
			break;
		case "/addMemberForm" : // 회원가입 양식
			nextPage = "test01/addMemberForm";
			break;
		case "/addMemberRun" : // 회원가입 처리
			nextPage = "redirect:/member/listMembers"; // forward가 아닌 redirect 처리가 필요함
			break;
		}
		
		if (nextPage.startsWith("redirect:")) { // redirect를 하는 경우
			response.sendRedirect(
					nextPage.substring(nextPage.indexOf("/"))); // redirect:/ 이후의 문자열 구해서 redirect 처리
		} else { // forward를 하는 경우
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(PREFIX + nextPage + POSTFIX);
			dispatcher.forward(request, response); // view쪽에 list를 넘겨줌
		}

	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
