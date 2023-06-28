package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SuppressWarnings("serial")
@WebServlet("/json1")
public class JsonServlet1 extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json;charset=utf-8");
		
//		String jsonStr = "[{\"name\" : \"박지성\", \"age\" : 25,"
//				+ " \"gender\" : \"남자\", \"nickname\" : \"날쌘돌이\"},";
//		jsonStr += "{\"name\" : \"손흥민\", \"age\" : 30,"
//				+ " \"gender\" : \"남자\", \"nickname\" : \"쏘니\"}]";
		
		// json의 문자열 처리가 불편함 -> 라이브러리(json-simple) 사용
		
		JSONArray jsonArray = new JSONArray(); // JS의 [] 생성
		JSONObject jsonObject = new JSONObject(); // {} 생성
		
		jsonObject.put("name", "박지성"); // {"name" : "박지성"}
		jsonObject.put("age", "25"); // {"name" : "박지성", "age" : 25}
		jsonObject.put("gender", "남자");
		jsonObject.put("nickname", "날쌘돌이");
		jsonArray.add(jsonObject); // [{"name" : "박지성", "age" : 25, ...}]
		
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("name", "손흥민");
		jsonObject2.put("age", "30");
		jsonObject2.put("gender", "남자");
		jsonObject2.put("nickname", "쏘니");
		jsonArray.add(jsonObject2); // [{...}, {...}]

		PrintWriter out = response.getWriter();
		out.print(jsonArray.toJSONString());
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
