package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InputServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get request");
		
		// 사용자 입력값 얻기
//		String subject = request.getParameter("subject"); // 체크박스에 여러개가 체크되어 있어도 한개의 값만 가져옴
		// form의 name 속성이 같은 이름(subject)으로 지정된 여러개의 값을 가져올 경우 getParameterValues 사용
		/*
		String[] values = request.getParameterValues("subject");
		for (String value : values) {
			System.out.println(value);
		}
		*/
		
		// MIME-TYPE(데이터 형식) 지정
		response.setContentType("text/html; charset=utf-8");
		
		StringBuffer sb = new StringBuffer();
		sb.append("<!doctype html>");
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>요청처리 결과</title>");
		sb.append("</head>");
		sb.append("<body>");
		
		// name 값을 얻어서 사용자 입력값 얻기
		Enumeration<String> enumer = request.getParameterNames();
		while (enumer.hasMoreElements()) { // enumer가 읽을 요소가 있는 동안 반복
			String name = enumer.nextElement();
			String str = "";
			if (!name.equals("subject")) {
				str = request.getParameter(name);
			} else {
				String[] values = request.getParameterValues(name);
				for (String value : values) {
					str += value + " ";
				}
			}
//			System.out.println("name: " + name + ", value: " + str); // 콘솔에 출력
			sb.append("name: " + name + ", value: " + str + "<br>"); 
		} //while
		sb.append("</body>");
		sb.append("</html>");
		
		PrintWriter out = response.getWriter();
		out.println(sb.toString()); // client 화면에 출력
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
