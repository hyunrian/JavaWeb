package sec03.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDao {

	private static LoginDao instance = new LoginDao();
	
	private LoginDao() {}
	
	public static LoginDao getInstance() {
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
	
	public boolean login(LoginDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select count(*) cnt from t_member"
					+ "		where id = ?"
					+ "		and pwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("cnt");
				if (count == 1) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return false;
	}
}
