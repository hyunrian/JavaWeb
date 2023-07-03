package util;

import javax.servlet.http.HttpServletRequest;

import sec03.ex01.BoardVo;

public class BoardParamUtil {

	public static BoardVo setData(HttpServletRequest request) {
		int bno = 0;
		if (request.getParameter("bno") != null) {
			bno = Integer.valueOf(request.getParameter("bno"));
		}
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String id = request.getParameter("id");
		
		BoardVo vo = new BoardVo();
		vo.setBno(bno);
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
		vo.setId(id);
		
		return vo;
	}
	
}
