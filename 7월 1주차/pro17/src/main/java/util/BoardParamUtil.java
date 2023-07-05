package util;

import javax.servlet.http.HttpServletRequest;

import sec03.ex01.BoardVo;

public class BoardParamUtil {

	public static BoardVo setData(HttpServletRequest request) {
		int bno = 0;
		int bgroup = 0;
		int bseq = 0;
		int blevel = 0;
		
		if (request.getParameter("bno") != null) {
			bno = Integer.valueOf(request.getParameter("bno"));
		}
		if (request.getParameter("bgroup") != null) {
			bgroup = Integer.valueOf(request.getParameter("bgroup"));
		}
		if (request.getParameter("bseq") != null) {
			bseq = Integer.valueOf(request.getParameter("bseq"));
		}
		if (request.getParameter("blevel") != null) {
			blevel = Integer.valueOf(request.getParameter("blevel"));
		}
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String id = request.getParameter("id");
		
		BoardVo vo = new BoardVo();
		vo.setBno(bno);
		vo.setBgroup(bgroup);
		vo.setBseq(bseq);
		vo.setBlevel(blevel);
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
		vo.setId(id);
		
		return vo;
	}
	
}
