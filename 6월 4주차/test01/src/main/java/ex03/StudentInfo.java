package ex03;

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
@WebServlet("/student/*")
public class StudentInfo extends HttpServlet {

	StudentDao dao = StudentDao.getInstance();
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();

		String pathInfo = request.getPathInfo();
		String nextPage = "";
		switch(pathInfo) {
		case "/studentList":
			nextPage = "/ex03/studentList.jsp";
			List<StudentVo> list = dao.getStudentList();
			request.setAttribute("list", list);
			break;
		case "/addStudent":
			String sno = request.getParameter("sno");
			String sname = request.getParameter("sname");
			String gender = request.getParameter("gender");
			String major = request.getParameter("major");
			int syear = Integer.valueOf(request.getParameter("syear"));
			int score = Integer.valueOf(request.getParameter("score"));
			nextPage = "redirect:/test01/student/studentList";
			boolean addResult = dao.addStudent(
					new StudentVo(sno, sname, gender, major, syear, score));
			
			session.setAttribute("addResult", addResult);
			break;
		case "/deleteStudent":
			String snoDelete = request.getParameter("sno");
			boolean deleteResult = dao.deleteStudent(snoDelete);
			nextPage = "redirect:/test01/student/studentList";
			session.setAttribute("deleteResult", deleteResult);
			break;
		case "/updateStudent" :
			String sno2 = request.getParameter("sno");
			String sname2 = request.getParameter("sname");
			String gender2 = request.getParameter("gender");
			String major2 = request.getParameter("major");
			int syear2 = Integer.valueOf(request.getParameter("syear"));
			int score2 = Integer.valueOf(request.getParameter("score"));
			boolean updateResult = dao.updateStudent(
					new StudentVo(sno2, sname2, gender2, major2, syear2, score2));
			session.setAttribute("updateResult", updateResult);
			nextPage = "redirect:/test01/student/studentList";
			break;
		}
		
		if (nextPage.startsWith("redirect:")) {
			response.sendRedirect(nextPage.substring(nextPage.indexOf("/")));
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
