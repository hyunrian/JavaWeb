package ex01;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "fourthServlet", urlPatterns = { "/fourth" })
public class FourthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("fourth init");
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("fourth doGet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
