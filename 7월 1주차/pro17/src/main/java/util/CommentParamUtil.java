package util;

import javax.servlet.http.HttpServletRequest;

import sec03.ex01.BoardVo;
import sec03.ex01.CommentVo;

public class CommentParamUtil {

	public static CommentVo setData(HttpServletRequest request) {
		
		CommentVo commentVo = new CommentVo();
		
		int bno = 0;
		if (request.getParameter("bno") != null) {
			bno = Integer.valueOf(request.getParameter("bno"));
		}
		String ccontent = request.getParameter("ccontent");
		commentVo.setBno(bno);
		commentVo.setCcontent(ccontent);
		return commentVo;
	}
	
}
