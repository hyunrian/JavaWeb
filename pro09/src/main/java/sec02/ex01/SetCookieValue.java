package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 쿠키를 생성해서 쿠키의 유효기간 설정, 응답에 보내기
		// javax.servlet.http.Cookie;
		// 유효기간 단위는 millisecond 
		Cookie cookie = new Cookie("cookieTest", URLEncoder.encode("JSP 프로그래밍입니다.", "utf-8")); // 유효하지 않은 문자 에러 발생하여 인코딩해줌
		// 한글이 URL에 포함될 경우 인코딩, 디코딩이 필요. 브라우저마다 처리되는 방식에 차이가 있기 때문에 charset 설정을 해주는 것이 좋음
		// PrintWriter가 print 하는 아래의 코드 역시 <html></html> 등의 코드 작성을 하지 않았지만 크롬에서 자동으로 생성해줌 -> 브라우저마다 다름!
		cookie.setMaxAge(60 * 60 * 24); // 24시간으로 유효기간 설정
		response.setContentType("text/html;charset=utf-8"); // 오타 주의!(test라고 썼음) 브라우저가 인식하지 못하는 mime-type이면 다운로드처리 됨 
		response.addCookie(cookie);
		PrintWriter out = response.getWriter();
		out.println("<h1>쿠키생성 완료</h1>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
