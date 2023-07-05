package util;

import javax.servlet.http.HttpServletRequest;

import sec03.ex01.BoardVo;
import sec03.ex01.CommentVo;

public class CommentParamUtil {

	public static CommentVo setData(HttpServletRequest request) {
		
		CommentVo commentVo = new CommentVo();
		
		int bno = 0;
		int cno = 0;
		if (request.getParameter("bno") != null) {
			bno = Integer.valueOf(request.getParameter("bno"));
		}
		if (request.getParameter("cno") != null) {
			cno = Integer.valueOf(request.getParameter("cno"));
		}
		String ccontent = request.getParameter("ccontent");
		commentVo.setBno(bno);
		commentVo.setCcontent(ccontent);
		commentVo.setCno(cno);
		return commentVo;
	}
	
}
