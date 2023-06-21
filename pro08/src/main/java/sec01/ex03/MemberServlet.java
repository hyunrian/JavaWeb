package sec01.ex03;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	
	// redirect, forward 개념 이해하기
	// 단순 화면 처리는 forward라고 생각(후에 데이터 전달이 필요할 수도 있기 때문)
	// db 변경인 경우 redirect, 데이터를 보여주는 경우(select) forward
	// 데이터 변경이 있는데 forward를 하면 처리하는 동안 새로고침 시 중복하여 변경이 될 수도 있음
	// redirect는 경로 앞에 /pro08을 써야 함
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
		if (command == null || command.equals("")) command = "list";
		
		switch (command) {
		case "list"	: // 목록
			// 회원목록(List<MemberVo>) 화면에 출력
			String data = "회원목록입니다"; // list라고 가정
			request.setAttribute("data", data);
			forwardRun(request, response, "list.jsp");
//			response.sendRedirect("list.jsp"); // 데이터 전달이 되지 않음
			break;
		case "addForm" : // 회원가입 화면
			forwardRun(request, response, "addForm.jsp");
			break;
		case "addRun" : // 회원가입 처리
			// db작업 했다고 가정 -> 회원목록으로 이동해야 함
			response.sendRedirect("/pro08/member");
			break;
		case "modifyForm" : // 회원수정 화면
			// db로부터 해당 아이디의 회원 정보 1명에 대한 값을 얻은 후 데이터를 저장하여 사용자화면에 보여줌
			request.setAttribute("member", "홍길동의 정보");
			forwardRun(request, response, "modifyForm.jsp");
			break;
		case "modifyRun" : // 회원수정 처리
			// db작업 했다고 가정 -> 회원목록으로 이동함
			response.sendRedirect("/pro08/member?command=list");
			break;
		case "delete" : // 회원삭제 처리
			// db 삭제 작업 -> 회원목록
			response.sendRedirect("/pro08/member?command=list");
			break;
		}
	} //doGet

	public void forwardRun(HttpServletRequest request, 
			HttpServletResponse response, String page) 
			// forward 작업이 여러번 필요하니 forward 대상 페이지도 필요
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
	
}
