package com.staff2303.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sql {
	final String USERNAME = "root";// DBMS접속 시 아이디
	final String PASSWORD = "root";// DBMS접속 시 비밀번호
	final String URL = "jdbc:mysql://localhost:3306/staff_board";
	static Connection con = null;
	static Statement st = null;
	static ResultSet result = null;
	static final String NUM = "NO";
	static final String TITLE = "Title";
	static final String WRITER = "Writer";
	static final String DATE = "Date";
	static final String HITS = "hits";
	public static Scanner sc = new Scanner(System.in);

	void run() {
		dbinit();
		Menu.run();
	}

	private void dbinit() {
		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			st = con.createStatement();
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}

	public static void showlist() {
		System.out.println("┌─────┭──────────────────────┭────────────┭───────┭──────────────────────┐");
		System.out.println(String.format("| %-3s | %-20s | %-10s | %-5s | %-20s |", NUM, TITLE, WRITER, HITS, DATE));
		System.out.println("├─────┼──────────────────────┼────────────┼───────┼──────────────────────┤");
		try {
			result = st.executeQuery("select * from board");
			while (result.next()) {
				String no = result.getString("b_no");
				String title = result.getString("b_title");
				String writer = result.getString("b_writer");
				String hits = result.getString("b_hits");
				String date = result.getString("b_date");
				System.out.println(
						String.format("| %-3s | %-20s | %-10s | %-5s | %-20s |", no, title, writer, hits, date));
			}
			System.out.println("└─────┵──────────────────────┵────────────┵───────┵──────────────────────┘");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showpost() {
		System.out.print("번호를 입력해주세요 : ");
		int n = sc.nextInt();
		System.out.println("┌──────────────────────┭────────────┭───────┭──────────────────────┐");
		System.out.println(String.format("| %-20s | %-10s | %-5s | %-20s |", TITLE, WRITER, HITS, DATE));
		try {
			result = st.executeQuery("select * from board where b_no =" + String.valueOf(n));
			result.next();
			String title = result.getString("b_title");
			String writer = result.getString("b_writer");
			String hits = result.getString("b_hits");
			String date = result.getString("b_date");
			String content = result.getString("b_content");
			System.out.println(String.format("| %-20s | %-10s | %-5s | %-20s |", title, writer, hits, date));
			System.out.println("└──────────────────────┵────────────┵───────┵──────────────────────┘");
			System.out.println("┌──────────────────────────────────────────────────────────────────┐");
			System.out.println(" " + content);
			System.out.println("└──────────────────────────────────────────────────────────────────┘");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void writepost() {
		System.out.println("제목 : ");
		String title = sc.next();
		System.out.println("작성자 : ");
		String writer = sc.next();
		System.out.println("내용 : ");
		String content = sc.next();
		try {
			st.executeUpdate("insert into board (b_title,b_writer,b_date,b_content,b_hits)" + " values ('" + title
					+ "','" + writer + "',now(),'" + content + "',0)");
			System.out.println("글등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updatepost() {
		System.out.println("수정할 글번호를 입력해주세요:");
		int up = sc.nextInt();
		System.out.println("제목 : ");
		String title = sc.next();
		System.out.println("내용 : ");
		String content = sc.next();
		try {
			st.executeUpdate("update board set b_title='" + title + "', b_content='" + content
					+ "', b_date=now() where b_no=" + String.valueOf(up));
			System.out.println("글수정 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deletepost() {
		System.out.println("삭제할 글번호를 입력해주세요 : ");
		int del = sc.nextInt();
		try {
			st.executeUpdate("delete from board where b_no=" + String.valueOf(del));
			System.out.println("글삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
