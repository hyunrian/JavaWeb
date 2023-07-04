package sec03.ex01;

import java.util.List;

public class BoardService {
	
	private static BoardService instance = new BoardService();
	
	private BoardService() {}
	
	public static BoardService getInstance() {
		return instance;
	}

	private BoardDao dao = BoardDao.getInstance();
	
	public boolean addArticle(BoardVo vo) {
		return dao.addArticle(vo);
	}
	
	public List<BoardVo> getList() {
		return dao.getList();
	}
	
	public BoardVo getDetail(int bno) {
		return dao.getDetail(bno);
	}
	
	public boolean modifyArticle(BoardVo vo) {
		return dao.modifyArticle(vo);
	}
	
	public boolean deleteArticle(int bno) {
		return dao.deleteArticle(bno);
	}
}
