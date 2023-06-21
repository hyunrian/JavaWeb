package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member2")
@SuppressWarnings("serial")
public class MemberServlet2 extends HttpServlet {
	
	MemberDao dao = MemberDao.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		List<MemberVo> list = dao.listMembers();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/viewMembers");
		dispatcher.forward(request, response);
	}
}
