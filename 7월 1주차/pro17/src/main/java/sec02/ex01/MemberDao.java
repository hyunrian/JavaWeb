package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {

	private static MemberDao instance = new MemberDao();
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
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
	
	// 로그인 기능
	public MemberVo selectByIdAndPwd(String id, String pwd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from t_member where id = ? and pwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joindate = rs.getDate("joindate");
				return new MemberVo(id, pwd, name, email, joindate);
			}
		} catch (Exception e) {
			
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	// 입력
	public boolean addMember(MemberVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "insert into t_member(id, pwd, name, email)"
					+ " values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	// 조회
	public List<MemberVo> listMembers() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from t_member order by id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<MemberVo> list = new ArrayList<>();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joindate = rs.getDate("joindate");
				list.add(new MemberVo(id, pwd, name, email, joindate));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return null;
	}
	
	// 수정
	public boolean editMember(MemberVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "update t_member"
					+ " set pwd = ?,"
					+ " name = ?,"
					+ " email = ?"
					+ " where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getId());
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		
		return false;
	}
	
	// 삭제
	public boolean deleteMember(String id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "delete t_member where id = '" + id + "'";
			pstmt = conn.prepareStatement(sql);
			int count = pstmt.executeUpdate();
			if (count == 1) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		
		return false;
	}
	
	// 이름 검색
	public List<MemberVo> searchByName(String searchName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from t_member"
//					+ " where name like '%' || ? || '%'"; // sql의 연결연산자 || 사용
//					+ " where name like ?";
					+ " where name like concat(concat('%', ?), '%')"; // oracle에서는 concat의 파라미터 2개라 중첩해서 사용함
			/* 이 상황에서 쿼리문을 작성할 수 있는 4가지 방법이 있음
			 * 1. "where name like '%"+searchName+"%'";
			 * 2. "where name like ''%' || ? || '%'";
			 * 3. "where name like ?"  &&   pstmt.setString(1, "%"+searchName+"%");
			 * 4. "where name like concat('%', ?, '%')";   concat() == 여러 문자열 하나로 합치기 
			 * */
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "%"+searchName+"%");
			pstmt.setString(1, searchName);
			rs = pstmt.executeQuery();
			List<MemberVo> list = new ArrayList<>();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joindate = rs.getDate("joindate");
				
				list.add(new MemberVo(id, pwd, name, email, joindate));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return null;
	}
	
	// 아이디 중복 확인
	public boolean isDupId(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select count(*) cnt from t_member where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("cnt"); 
				// cnt로 별칭을 사용하였기 때문에 해당 컬럼명으로 데이터를 가져올 수 있음
				if (count > 0) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return false;
	}
	
	// 아이디로 조회
	public MemberVo getMemberById(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from t_member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joindate = rs.getDate("joindate");
				return new MemberVo(id, pwd, name, email, joindate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
}
