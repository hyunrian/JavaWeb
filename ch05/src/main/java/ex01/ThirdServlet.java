package ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third") // 자동 서블릿 등록/매핑 (사용자가 직접 구현한 서블릿만 애너테이션 사용 가능)
@SuppressWarnings("serial")
public class ThirdServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("third init");
	}
	
	@Override
	public void destroy() {
		System.out.println("third destroy");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("third doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("third doPost");
	}
	
}
