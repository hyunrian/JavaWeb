package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import util.CommentParamUtil;

@SuppressWarnings("serial")
@WebServlet("/comment/*") 
public class CommentController extends HttpServlet { 
	
	private final String PREFIX = "/WEB-INF/views/"; 
	private final String POSTFIX = ".jsp";
	private CommentService commentService = CommentService.getInstance();

	@SuppressWarnings({ "unchecked", "static-access" })
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo();
		CommentParamUtil commentParamUtil = new CommentParamUtil();
		CommentVo commentVo = null;
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		String data = "";
		
		switch (pathInfo) {
		case "/addComment":
			commentVo = commentParamUtil.setData(request);
			commentVo.setId(loginId);
			boolean commentResult = commentService.addComment(commentVo);
			data = String.valueOf(commentResult);
			break;
		case "/getCommentList":
			commentVo = commentParamUtil.setData(request);
			List<CommentVo> list = 
					commentService.getComment(commentVo.getBno());
			// [{}, {}, {}, ...]의 형태로 만들어야 함(자바스크립트 객체 형태) -> JSONArray 사용
			// 그냥 list로 넘기면 자바스크립트에서 처리할 수가 없기 때문
			JSONArray jsonArray = new JSONArray(); // [] 만들기
			for (CommentVo vo : list) {
				JSONObject jsonObject = new JSONObject(); // {} 만들기
				jsonObject.put("cno", vo.getCno());
				jsonObject.put("ccontent", vo.getCcontent());
				jsonObject.put("id", vo.getId());
				jsonObject.put("regdate", vo.getRegdate().toString());
				// 날짜데이터를 toString 하지 않으면 자바스크립트에서 처리할 수 없음
				jsonObject.put("bno", vo.getBno());
				jsonArray.add(jsonObject);
			}
			data = jsonArray.toJSONString();
			break;
		case "/delete":
			commentVo = commentParamUtil.setData(request);
			int cno = commentVo.getCno();
			Map<String, Object> map = new HashMap<>();
			map.put("cno", cno);
			map.put("loginId", loginId);
			boolean deleteResult = commentService.deleteComment(map);
			data = String.valueOf(deleteResult);
			break;
		case "/update":
			commentVo = commentParamUtil.setData(request);
			commentVo.setId(loginId); // dao에서 작성자 확인 쿼리 작성 목적
			boolean updateResult = commentService.updateComment(commentVo);
			data = String.valueOf(updateResult);
			break;
		}
		
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(data);
		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
