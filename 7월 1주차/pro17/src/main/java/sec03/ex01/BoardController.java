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

import util.BoardParamUtil;

@SuppressWarnings("serial")
@WebServlet("/board/*") 
						

public class BoardController extends HttpServlet { 
	
	private final String PREFIX = "/WEB-INF/views/"; 
	private final String POSTFIX = ".jsp"; 
	BoardService boardService = BoardService.getInstance();

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String pathInfo = request.getPathInfo(); 
		
		String nextPage = "";
		BoardVo boardVo = null;
		HttpSession session = request.getSession();
		
		switch (pathInfo) {
		case "/addArticleForm" : // 글쓰기 폼
			nextPage = "board/addArticleForm";
			break;
		case "/addArticleRun": // 글쓰기 처리
			boardVo = BoardParamUtil.setData(request);
			String id = (String)session.getAttribute("loginId");
			boardVo.setId(id);
			boolean addResult = boardService.addArticle(boardVo);
			session.setAttribute("addResult", addResult);
			nextPage = "redirect:/board/getList";
			break;
		case "/getList": // 목록
			List<BoardVo> list = boardService.getList();
			request.setAttribute("list", list);
			nextPage = "board/articleList";
			break;
		case "/articleDetail":
			boardVo = BoardParamUtil.setData(request);
			boardVo = boardService.getDetail(boardVo.getBno());
			request.setAttribute("boardVo", boardVo);
			nextPage = "/board/articleDetail";
			break;
		case "/modifyArticleRun":
			boardVo = BoardParamUtil.setData(request);
			boolean modifyResult = boardService.modifyArticle(boardVo);
			session.setAttribute("modifyResult", modifyResult);
			nextPage = "redirect:/board/articleDetail?bno=" + boardVo.getBno();
			break;
		case "/deleteArticle":
			boardVo = BoardParamUtil.setData(request);
			boolean deleteResult = boardService.deleteArticle(boardVo.getBno());
			session.setAttribute("deleteResult", deleteResult);
			nextPage = "redirect:/board/getList";
			break;
		case "/replyForm":
			boardVo = BoardParamUtil.setData(request);
			request.setAttribute("boardVo", boardVo);
			nextPage = "board/replyForm";
			break;
		case "/replyRun":
			boardVo = BoardParamUtil.setData(request);
			String loginId = (String)session.getAttribute("loginId");
			boardVo.setId(loginId);
			boardService.replyRun(boardVo);
			nextPage = "redirect:/board/getList";
			break;
		}
		
		if (nextPage.startsWith("redirect:")) { // redirect를 하는 경우
			response.sendRedirect(
					nextPage.substring(nextPage.indexOf("/"))); // redirect:/ 이후의 문자열 구해서 redirect 처리
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
