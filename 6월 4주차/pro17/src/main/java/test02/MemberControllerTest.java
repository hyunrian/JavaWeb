package test02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/memberTest/*")
public class MemberControllerTest extends HttpServlet {
	
	MemberService service = MemberService.getInstance();

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
//		System.out.println(pathInfo);
		String path = "";
		
		switch(pathInfo) {
		case "/listMembers":
			List<MemberVo> list = service.getMemberList();
			request.setAttribute("list", list);
			path = "/WEB-INF/views/test02/listMembers.jsp";
			break;
		case "/joinForm":
			path = "/WEB-INF/views/test02/joinForm.jsp";
			break;
		case "/joinRun":
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVo vo = new MemberVo(id, pwd, name, email);
			boolean addResult = service.addMember(vo);
			HttpSession session = request.getSession();
			session.setAttribute("addResult", addResult);
			path = "redirect:/memberTest/listMembers";
			break;
		}
		
		if (path.startsWith("redirect:/")) {
			String page = path.substring(path.indexOf("/"));
			response.sendRedirect(page);
		} else {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(path);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
