package sec03.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentDao {
	
	private static CommentDao instance = new CommentDao();
	
	private CommentDao() {}
	
	public static CommentDao getInstance() {
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

	public List<CommentVo> getComments(int bno) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from t_comment "
					+ "	where bno = ? order by cno desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			List<CommentVo> list = new ArrayList<>();
			while (rs.next()) {
				int cno = rs.getInt("cno");
				String ccontent = rs.getString("ccontent");
				String id = rs.getString("id");
				Date regdate = rs.getDate("regdate");
				list.add(new CommentVo(cno, ccontent, id, regdate, bno));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace(); 
		} finally {
			closeAll(pstmt, rs);
		}
		return null;
	}
	
	public boolean addComment(CommentVo commentVo) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into t_comment"
					+ "	values(seq_comment_cno.nextval, ?, ?, sysdate, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentVo.getCcontent());
			pstmt.setString(2, commentVo.getId());
			pstmt.setInt(3, commentVo.getBno());
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, null);
		}
		return false;
	}
	
	public boolean deleteComment(Map<String, Object> map) {
		PreparedStatement pstmt = null;
		try {
			String loginId = (String)map.get("loginId");
			int cno = (Integer)map.get("cno");
			System.out.println("id:" + loginId + ", cno: " + cno);
			String sql = "delete from t_comment "
					+ "	where cno = ?"
					+ "	and id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cno);
			pstmt.setString(2, loginId);
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(pstmt, null);
		}
		return false;
	}
}
