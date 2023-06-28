package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import sec02.ex01.MemberDao;
import sec02.ex01.MemberVo;

@SuppressWarnings("serial")
@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {

	private MemberDao dao = MemberDao.getInstance();
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json;charset=utf-8");
		
		List<MemberVo> list = dao.listMembers();
		JSONArray jsonArray = new JSONArray();

		for (MemberVo vo : list) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("id", vo.getId());
			jsonObject.put("pwd", vo.getPwd());
			jsonObject.put("name", vo.getName());
			jsonObject.put("email", vo.getEmail());
			jsonObject.put("joindate", vo.getJoindate().toString());
			jsonArray.add(jsonObject);
		}
		PrintWriter out = response.getWriter();
		out.print(jsonArray.toJSONString());
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
