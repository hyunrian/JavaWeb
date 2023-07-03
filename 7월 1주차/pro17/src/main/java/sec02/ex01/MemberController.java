package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MemberParamUtil;

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
//		System.out.println("pathInfo: "+pathInfo);
		
		String nextPage = "";
		MemberVo vo = null;
		HttpSession session = request.getSession();
		
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
			vo = MemberParamUtil.setData(request);
			boolean addResult = memberService.addMember(vo);
			// request에 담아봤자 redirect하므로 소용이 없음 -> 영역이 더 넓은 세션 사용
			// 세션에 담으면 parameter를 활용하지 않아도 됨(새로고침해도 ㄱㅊ)
			// 회원가입처리 jsp에서 작업이 끝난 후 session에 담은 attrubute를 삭제해야 함
			session.setAttribute("addResult", addResult);
			nextPage = "redirect:/member/listMembers"; // forward가 아닌 redirect 처리가 필요함
			break;
		case "/modifyMemberForm": // 회원 수정 양식
			vo = MemberParamUtil.setData(request);
			vo = memberService.getMemberById(vo.getId());
			request.setAttribute("vo", vo);
			nextPage = "test01/modifyMemberForm";
			break;
		case "/modifyMemberRun": // 회원 수정 처리
			vo = MemberParamUtil.setData(request);
			boolean modifyResult = memberService.editMember(vo);
			session.setAttribute("modifyResult", modifyResult);
			nextPage = "redirect:/member/listMembers";
			break;
		case "/removeMemberRun": // 회원 삭제 처리
			vo = MemberParamUtil.setData(request);
			boolean deleteResult = memberService.deleteMember(vo.getId());
			session.setAttribute("deleteResult", deleteResult);
			nextPage = "redirect:/member/listMembers";
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
