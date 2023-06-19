package ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet {

	
	// init : 최초 요청 시 한번만 실행
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	
	// destroy : 서버 중지 시 한번만 실행
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	// doGet : get 방식 요청 시 요청할 때마다 실행
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
	}
	
	// doPost : post 방식 요청 시 요청할 때마다 실행
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
	}
	
}
