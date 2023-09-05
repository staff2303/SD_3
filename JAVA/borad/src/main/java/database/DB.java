package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	final static String USERNAME = "staff2303";// DBMS접속 시 아이디
	final static String PASSWORD = "staff7161";// DBMS접속 시 비밀번호
	final static String URL = "jdbc:mysql://staff2303.cafe24.com/staff2303";
	static Connection con = null;
	public static Statement st = null;
	public static ResultSet result = null;
	
	public static void run() {
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int login(String id, String pw) {
		try {
			DB.result = DB.st.executeQuery("select m_pw from member where m_id='" + id + "'");
			if (DB.result.next()) {
				if (DB.result.getString("m_pw").equals(pw)) {
					return 1; // 로그인성공
				} else {
					return 0; // 비밀번호틀림
				}
			}
			return -1; // 아이디없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // 데이터 베이스오류
	}

	public static int singup(String name, String id, String pw, String cpw) {
		if (pw.equals(cpw)) {
			try {
				result = st.executeQuery("select count(*) from member where m_id='" + id + "'");
				result.next();
				String count = result.getString("count(*)");
				if (count.equals("1")) {
					return 0; // 중복아이디
				} else {
					st.executeUpdate("insert into member (m_name, m_id, m_pw, m_date) values ('" + name + "','" + id
							+ "','" + pw + "',now())");
					return 1; // 회원가입성공
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return -2; // 데이터베이스오류
		}
		return -1; // 비밀번호확인오류
	}

	public static int post(String title, String id, String content) {
		try {
			st.executeUpdate("insert into board (b_title,b_writer,b_date,b_content,b_hits) values ('" + title + "','"
					+ id + "',now(),'" + content + "',0)");
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static int update(String no, String title, String content) {
		try {
			st.executeUpdate("update board set b_title='" + title + "', b_content='" + content
					+ "', b_date=now() where b_no=" + no);
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static void close() {
		try {
			st.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}