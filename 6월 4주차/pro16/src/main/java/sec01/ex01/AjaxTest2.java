package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/xml;charset=utf-8");
		PrintWriter out = response.getWriter();
		String rData = "";
		rData += "<main>"
				+ "	<book>"
				+ "		<title>"
				+ "			<![CDATA[초보자를 위한 자바 프로그래밍]]>" 
							// CDATA : character data. 데이터를 문자처리. <>도 태그가 아닌 문자로 처리함
				+ "		</title>"
				+ "		<writer>"
				+ "			<![CDATA[인포북스 저 | 이병승]]>"
				+ "		</writer>"
				+ "		<image>"
				+ "			<![CDATA[http://localhost/pro16/images/cat.png]]>"
				+ "		</image>"
				+ "	</book>"
				+ "	<book>"
				+ "		<title>"
				+ "			<![CDATA[모두의 파이썬]]>" 
				+ "		</title>"
				+ "		<writer>"
				+ "			<![CDATA[길벗 저 | 이승찬]]>"
				+ "		</writer>"
				+ "		<image>"
				+ "			<![CDATA[http://localhost/pro16/images/fox.png]]>"
				+ "		</image>"
				+ "	</book>"
				+ "</main>";
		
		out.write(rData);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
