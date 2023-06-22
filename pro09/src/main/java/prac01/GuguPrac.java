package prac01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guguPrac")
public class GuguPrac extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num1 = Integer.valueOf(request.getParameter("num1"));
		int num2 = Integer.valueOf(request.getParameter("num2"));
		
		response.setContentType("text=html;charset=utf-8");
		
		String html = "";
		html += "<table border='1'>";
		for (int i = 1; i <= 9; i++) {
			if (num2 == i) {
				html += "<tr style='background-color:yellow; color:red;'>";
			} else {
				html += "<tr>";
			}
			html += "<td width='100px' align='center'>" + num1 + " * " + i + "</td>"
			+ "<td width='100px' align='center'>" + (num1*i) + "</td>"
			+ "</tr>";
		}
		html += "</table>";
		
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
