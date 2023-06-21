package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer sb = new StringBuffer();
		List<MemberVo> list = (List<MemberVo>)request.getAttribute("list");
		
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
		
		sb.append("</body>\n");
		sb.append("</html>");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(sb.toString());
	}
	
}
