package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;

	// 기본생성자를 통한 DB연결
	public MemberDAO() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			DataSource source = (DataSource) ctx.lookup("jdbc_mariadb");
			con = source.getConnection();
			System.out.println("DBCP연결성공");
		} catch (Exception e) {
			System.out.println("DBCP연결실패");
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		new MemberDAO();
	}

	public Map<String, String> getMembershipMap(String id, String pwd) {

		// 회원정보를 저장할 Map컬렉션 생성
		Map<String, String> maps = new HashMap<String, String>();

		String query = "SELECT id, pass, name FROM " + " membership WHERE id=? AND pass=?";
		System.out.println(id + "<>" + pwd);
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();

			// 회원정보가 있다면 put()을 통해 정보를 저장한다.
			if (rs.next()) {
				maps.put("id", rs.getString("id"));
				maps.put("pass", rs.getString("pass"));
				maps.put("name", rs.getString("name"));
			} else {
				System.out.println("결과셋이 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("membershipDTO오류");
			e.printStackTrace();
		}

		return maps;
	}

	public void close() {
		try {
			// 사용된 자원이 있다면 자원해제 해준다.
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("자원반납시 예외발생");
		}
	}
}
