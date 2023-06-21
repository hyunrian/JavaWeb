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
	StringBuffer sb;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		sb = new StringBuffer(); // 필드에서 생성하면 계속 append되어 제대로 작동하지 않음
		String command = request.getParameter("command");
		if (command == null) command = "";
		
		switch (command) { // command가 null이면 에러 발생
		case "addMember" :
			includeTop();
			addMember(request);
			includeBottom(response);
			break;
		case "delMember" :
			includeTop();
			delMember(request);
			includeBottom(response);
			break;
		default :
			includeTop();
			listMembers(response);
			includeBottom(response);
			break;
		}
		
	}
	
	private void delMember(HttpServletRequest request) 
					throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean result = dao.deleteMember(id);
		if (result) sb.append("<script>alert('삭제 완료');");
		else sb.append("<script>alert('삭제 실패');");
		sb.append("location.href='/pro07/member';</script>");
		
	}

	private void includeTop() {
		sb.append("<!doctype html>\n");
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("</head>\n");
		sb.append("<meta charset='utf-8'>\n");
		sb.append("<title>회원목록</title>\n");
		sb.append("<body>\n");
	}
	
	private void includeBottom(HttpServletResponse response) 
					throws ServletException, IOException {
		sb.append("</body>\n");
		sb.append("</html>");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(sb.toString());
	}
	
	private void addMember(HttpServletRequest request) 
					throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		boolean result = dao.addMember(new MemberVo(id, pwd, name, email));
		System.out.println("result : " + result);
		if (result) {
			sb.append("<script>alert('가입완료');");
			sb.append("location.href='/pro07/member';</script>");
		} else {
			sb.append("<script>alert('가입실패');");
			sb.append("location.href='/pro07/memberForm.html';</script>");
		}
		
	}

	private void listMembers(HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberVo> list = dao.listMembers();
		
		sb.append("		<table border='1'>\n");
		sb.append("			<tr>\n");
		sb.append("				<th>아이디</th>\n");
		sb.append("				<th>비밀번호</th>\n");
		sb.append("				<th>이름</th>\n");
		sb.append("				<th>이메일</th>\n");
		sb.append("				<th>가입일</th>\n");
		sb.append("				<th>삭제</th>\n");
		sb.append("			</tr>\n");
		
		for (MemberVo vo : list) {
			sb.append("<tr>\n");
			sb.append("		<td>" + vo.getId() + "</td>\n");
			sb.append("		<td>" + vo.getPwd() + "</td>\n");
			sb.append("		<td>" + vo.getName() + "</td>\n");
			sb.append("		<td>" + vo.getEmail() + "</td>\n");
			sb.append("		<td>" + vo.getJoindate() + "</td>\n");
			sb.append("		<td><a href='/pro07/member?command=delMember&id=" + vo.getId() + "'>삭제</a></td>\n"); // href='#' : blank link. 작동하진 않지만 형식을 갖춤
			sb.append("</tr>\n");
		}
		
		sb.append("		</table>\n");
		sb.append("		<a href='/pro07/memberForm.html'>회원가입</a>\n");
	}
	
	
}
