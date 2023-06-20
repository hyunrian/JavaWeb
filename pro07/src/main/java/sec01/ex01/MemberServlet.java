package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
@SuppressWarnings("serial")
public class MemberServlet extends HttpServlet {
	
	MemberDao dao = MemberDao.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		String command = request.getParameter("command");
		
		switch (command) {
		case "addMember" :
			addMember(request, response);
			break;
		default :
			listMembers(response);
			break;
		}
		
		
		
	}
	
	private void addMember(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		boolean result = dao.addMember(new MemberVo(id, pwd, name, email));
		String message = "";
		if (result) message = "<script>alert('가입완료')</script>";
		else message = "<script>alert('가입실패')</script>";
		System.out.println("message:" + message);
		
		
		
	}

	private void listMembers(HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberVo> list = dao.listMembers();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!doctype html>\n");
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("</head>\n");
		sb.append("<meta charset='utf-8'>\n");
		sb.append("<title>회원목록</title>\n");
		sb.append("<body>\n");
		sb.append("		<table border='1'>\n");
		sb.append("			<tr>\n");
		sb.append("				<th>아이디</th>\n");
		sb.append("				<th>비밀번호</th>\n");
		sb.append("				<th>이름</th>\n");
		sb.append("				<th>이메일</th>\n");
		sb.append("				<th>가입일</th>\n");
		sb.append("			</tr>\n");
		
		for (MemberVo vo : list) {
			sb.append("<tr>\n");
			sb.append("		<td>" + vo.getId() + "</td>\n");
			sb.append("		<td>" + vo.getPwd() + "</td>\n");
			sb.append("		<td>" + vo.getName() + "</td>\n");
			sb.append("		<td>" + vo.getEmail() + "</td>\n");
			sb.append("		<td>" + vo.getJoindate() + "</td>\n");
			sb.append("</tr>\n");
		}
		
		sb.append("		</table>\n");
		sb.append("</body>\n");
		sb.append("</html>");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(sb.toString());
	}
	
	
}
