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
	
	private Connection conn;
	
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	private void closeAll(PreparedStatement pstmt, ResultSet rs) {
		if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
		if (rs != null) try {rs.close();} catch (Exception e) {}
	}
	
	public boolean addArticle(BoardVo vo) {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into t_board "
					+ "		values(seq_board_bno.nextval, seq_board_bno.nextval,"
					+ " 0, 0, ?, ?, ?, sysdate, 0, 'n')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBtitle());
			pstmt.setString(2, vo.getBcontent());
			pstmt.setString(3, vo.getId());
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, null);
		}
		return false;
	}
	
	public List<BoardVo> getList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from t_board order by bgroup desc, bseq";
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
				String delete_yn = rs.getString("delete_yn");
				list.add(new BoardVo(bno, bgroup, bseq, 
						blevel, btitle, bcontent, id, regdate, readcount, delete_yn));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, rs);
		}
		
		return null;
	}
	
	public BoardVo getDetail(int bno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
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
			closeAll(pstmt, rs);
		}
		return null;
	}
	
	public boolean modifyArticle(BoardVo vo) {
		PreparedStatement pstmt = null;
		
		try {
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
			closeAll(pstmt, null);
		}
		return false;
	}
	
	public boolean deleteArticle(int bno) {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from t_board where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, null);
		}
		return false;
	}
	
	public void increaseCount(int bno) { // 조회수 증가
		PreparedStatement pstmt = null;
		try {
			String sql = "update t_board set"
					+ "		readcount = readcount + 1"
					+ "		where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, null);
		}
	}
	
	public void updateSeq(BoardVo vo) {
		PreparedStatement pstmt = null;
		try {
			String sql = "update t_board set"
					+ "		bseq = bseq + 1"
					+ "		where bgroup = ?"
					+ "		and bseq > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBgroup());
			pstmt.setInt(2, vo.getBseq()+1);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, null);
		}
	}
	
	public void addReply(BoardVo vo) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into t_board "
					+ "		values(seq_board_bno.nextval,"
					+ " ?, ?, ?, ?, ?, ?, sysdate, 0, 'n')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBgroup());
			pstmt.setInt(2, vo.getBseq()+1);
			pstmt.setInt(3, vo.getBlevel()+1);
			pstmt.setString(4, vo.getBtitle());
			pstmt.setString(5, vo.getBcontent());
			pstmt.setString(6, vo.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, null);
		}
	}
	
	public boolean hasReply(BoardVo vo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select count(*) cnt from t_board "
					+ "		where bgroup = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBgroup());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				if (cnt > 1) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, rs);
		}
		return false;
	}
	
	public void updateDeleteYN(int bno) {
		PreparedStatement pstmt = null;
		try {
			String sql = "update t_board set"
					+ "	delete_yn = 'y' where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, null);
		}
	}
	
}
