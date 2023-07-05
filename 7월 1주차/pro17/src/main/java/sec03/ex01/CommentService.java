package sec03.ex01;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentService {
	
	private CommentDao commentDao = CommentDao.getInstance();

	private static CommentService instance = new CommentService();
	
	private CommentService() {}
	
	public static CommentService getInstance() {
		return instance;
	}
	
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
	
	// 댓글 등록
	public boolean addComment(CommentVo commentVo) {
		Connection conn = null;
		try {
			conn = getConnection();
			commentDao.setConn(conn);
			boolean commentResult = commentDao.addComment(commentVo);
			return commentResult;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		return false;
	}
	
	// 댓글 조회
	public List<CommentVo> getComment(int bno) {
		Connection conn = null;
		try {
			conn = getConnection();
			commentDao.setConn(conn);
			return commentDao.getComments(bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		return null;
	}
	
	public boolean deleteComment(Map<String, Object> map) {
		Connection conn = null;
		try {
			conn = getConnection();
			commentDao.setConn(conn);
			return commentDao.deleteComment(map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConn(conn);
		}
		return false;
	}
}
