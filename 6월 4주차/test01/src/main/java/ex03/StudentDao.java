package ex03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class StudentDao {
	
	private static StudentDao instance = new StudentDao();
	
	private StudentDao() {}
	
	public static StudentDao getInstance() {
		return instance;
	}
	
	public Connection getConnection() {
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)((Context)context.lookup("java:comp/env"))
					.lookup("jdbc/oracleDB");
			Connection conn = ds.getConnection();
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(Connection conn, 
			PreparedStatement pstmt, ResultSet rs) {
		if (conn != null) try {conn.close();} catch (Exception e) {}
		if (pstmt != null) try {pstmt.close();} catch (Exception e) {}
		if (rs != null) try {rs.close();} catch (Exception e) {}
	}
	
	// 학생 조회
	public List<StudentVo> getStudentList() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from t_student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<StudentVo> list = new ArrayList<>();
			while (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String gender = rs.getString("gender");
				String major = rs.getString("major");
				int syear = rs.getInt("syear");
				int score = rs.getInt("score");
				list.add(new StudentVo(sno, sname, gender, major, syear, score));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	// 학생 입력
	public boolean addStudent(StudentVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into t_student values(?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSno());
			pstmt.setString(2, vo.getSname());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getMajor());
			pstmt.setInt(5, vo.getSyear());
			pstmt.setInt(6, vo.getScore());
			int count = pstmt.executeUpdate();
			if (count > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	// 학생 수정
	public boolean updateStudent(StudentVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "update t_student set "
					+ " sname=?, gender=?, major=?, syear=?, score=?"
					+ " where sno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSname());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getMajor());
			pstmt.setInt(4, vo.getSyear());
			pstmt.setInt(5, vo.getScore());
			pstmt.setString(6, vo.getSno());
			int count = pstmt.executeUpdate();
			if (count > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	// 학생 삭제
	public boolean deleteStudent(String sno) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "delete t_student where sno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sno);
			int count = pstmt.executeUpdate();
			if (count > 0) return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}

	// 학생 1명 조회
	public StudentVo get1Student(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from t_student where sno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String gender = rs.getString("gender");
				String major = rs.getString("major");
				int syear = rs.getInt("syear");
				int score = rs.getInt("score");
				return new StudentVo(sno, sname, gender, major, syear, score);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
}
