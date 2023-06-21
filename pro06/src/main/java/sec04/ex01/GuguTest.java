package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guguTest")
public class GuguTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_num = request.getParameter("user_num");
		int num = Integer.valueOf(user_num);
		String output = "";
		String color = "";
		final String COLOR_EVEN = "#EBF5FB";
		final String COLOR_ODD = "#FDEDEC";
		
		response.setContentType("text/html;charset=utf-8");
		
		output += "<table border='1'>"
				+ "<tr align='center'>"
				+ "<td colspan=4 style='background-color:#E8DAEF; font-weight:bold;'>"+ num +"단 출력</td>"
				+ "</tr>";
		for (int i = 1; i <= 9; i++) {
			if (i % 2 == 1) color = COLOR_ODD;
			else color = COLOR_EVEN;
			output += "<tr align='center' style='background-color:"+ color +"'>"
					+ "<td width='200px'><input type='radio' name='rd'>"+ i +"</td>"
					+ "<td width='200px'><input type='checkbox'>"+ i +"</td>"
					+ "<td width='400px'>" + num + " * " + i + "</td>"
					+ "<td width='400px'>"+ (num * i) +"</td>"
					+ "</tr>";
		}
		output += "</table>";
		
		PrintWriter out = response.getWriter();
		out.println(output);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
