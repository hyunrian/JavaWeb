package sec03.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {

	private static BoardDao instance = new BoardDao();
	
	private BoardDao() {}
	
	public static BoardDao getInstance() {
		return instance;
	}
	
	private Connection getConnection() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)((Context)context.lookup("java:comp/env"))
								.lookup("jdbc/oracleDB"); // 정해져있는 이름(java:comp/env)을 사용해야 함
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) try {conn.close();} catch (Exception e) {}
		if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
		if (rs != null) try {rs.close();} catch (Exception e) {}
	}
	
	public boolean addArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into t_board "
					+ "		values(seq_board_bno.nextval, seq_board_bno.nextval,"
					+ " 0, 0, ?, ?, ?, sysdate, 0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setString(3, vo.getId());
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	public List<BoardVo> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from t_board order by bgroup desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<BoardVo> list = new ArrayList<>();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				int bgroup = rs.getInt("bgroup");
				int bseq = rs.getInt("bseq");
				int blevel = rs.getInt("blevel");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String id = rs.getString("id");
				Date regdate = rs.getDate("regdate");
				int readcount = rs.getInt("readcount");
				list.add(new BoardVo(bno, bgroup, bseq, 
						blevel, btitle, bcontent, id, regdate, readcount));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return null;
	}
	
	public BoardVo getDetail(int bno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from t_board where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int bgroup = rs.getInt("bgroup");
				int bseq = rs.getInt("bseq");
				int blevel = rs.getInt("blevel");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String id = rs.getString("id");
				Date regdate = rs.getDate("regdate");
				int readcount = rs.getInt("readcount");
				return new BoardVo(bno, bgroup, bseq, 
						blevel, btitle, bcontent, id, regdate, readcount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	public boolean modifyArticle(BoardVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "update t_board"
					+ "		set btitle = ?,"
					+ "			bcontent = ?"
					+ "		where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setInt(3, vo.getBno());
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
}
