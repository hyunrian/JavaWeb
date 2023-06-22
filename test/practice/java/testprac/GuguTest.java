package testprac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GuguTest extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		int num1 = Integer.valueOf(request.getParameter("num1"));
		int num2 = Integer.valueOf(request.getParameter("num2"));
		
		if (!(2 <= num1 && num1 <= 9 && 1 <= num2 && num2 <= 9)) {
			out.println("<script>"
					+ " alert('유효한 값을 입력하세요.');"
					+ " location.href='/javaweb/guguInput.html';"
					+ "</script>");
			return;
		} 
		
		String html = "";
		
		html += "<table border='1' style='text-align:center;'>";
		for (int i = 1; i <= 9; i++) {
			if (num2 == i) {
				html += "<tr style='background-color:red; color:white;'>";
			} else {
				html += "<tr>";
			}
			html += "<td width='200px'>"+ num1 + "*" + i + "</td>"
				+ "<td width='200px'>" + (num1*i) + "</td>"
				+ "</tr>";
		}
		html += "</table>";
		out.println(html);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}
