package sec03.ex01;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardService {
	
	private static BoardService instance = new BoardService();
	
	private BoardService() {}
	
	public static BoardService getInstance() {
		return instance;
	}

	private BoardDao dao = BoardDao.getInstance();
	
	private Connection getConnection() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)(
					(Context)context.lookup("java:comp/env"))
					.lookup("jdbc/oracleDB");
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeConn(Connection conn) {
		if (conn != null) try {conn.close();} catch (Exception e) {}
	}
	
	public boolean addArticle(BoardVo vo) {
		Connection conn = null;
		try {
			conn = getConnection();
			dao.setConn(conn);
			return dao.addArticle(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		return false;
	}
	
	public List<BoardVo> getList() {
		Connection conn = null;
		try {
			conn = getConnection();
			dao.setConn(conn);
			return dao.getList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		return null;
	}
	
	public BoardVo getDetail(int bno) {
		Connection conn = null;
		BoardVo vo = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false); // transaction 시작(아래 작업을 한단위로 묶기 위해)
			dao.setConn(conn);
			dao.increaseCount(bno); // 조회수 증가
			vo = dao.getDetail(bno); // 글 내용 보기
			conn.commit();
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			try {conn.rollback();} catch (SQLException e1) {}
		} finally {
			try {conn.setAutoCommit(true);} catch (SQLException e) {}
			closeConn(conn);
		}
		return null;
	}
	
	public boolean modifyArticle(BoardVo vo) {
		Connection conn = null;
		try {
			conn = getConnection();
			dao.setConn(conn);
			return dao.modifyArticle(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		return false;
	}
	
	public boolean deleteArticle(BoardVo vo) {
		Connection conn = null;
		try {
			conn = getConnection();
			dao.setConn(conn);
			dao.hasReply(vo);
			boolean hasReply = dao.hasReply(vo);
			if (hasReply) {
				dao.updateDeleteYN(vo.getBno());
				return true;
			} else {
				return dao.deleteArticle(vo.getBno());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		return false;
	}
	
	public void replyRun(BoardVo vo) {
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			dao.setConn(conn);
			// 같은 글그룹 내에서 원글의 시퀀스보다 큰 값을 가지는 글들에 대해 시퀀스 1 증가(update)
			dao.updateSeq(vo);
			// 새로운 글달기(insert)
			dao.addReply(vo);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {conn.rollback();} catch (SQLException e1) {}
		} finally {
			try {conn.setAutoCommit(true);} catch (SQLException e) {}
			closeConn(conn);
		}
	}
	
}
