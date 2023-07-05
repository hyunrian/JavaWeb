package sec03.ex01;

import java.io.IOException;
import java.util.List;

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
		String nextPage = "";
		HttpSession session = request.getSession();
		
		switch (pathInfo) {
		case "/addComment":
			commentVo = commentParamUtil.setData(request);
			String loginId = (String)session.getAttribute("loginId");
			commentVo.setId(loginId);
			boolean commentResult = commentService.addComment(commentVo);
			request.setAttribute("data", commentResult);
			nextPage = "data";
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
			request.setAttribute("data", jsonArray.toJSONString());
			nextPage = "data";
			break;
		}
		
		if (nextPage.startsWith("redirect:")) { // redirect를 하는 경우
			response.sendRedirect(
					nextPage.substring(nextPage.indexOf("/")));
		} else { // forward를 하는 경우
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher(PREFIX + nextPage + POSTFIX);
			dispatcher.forward(request, response); // view쪽에 list를 넘겨줌
		}
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
