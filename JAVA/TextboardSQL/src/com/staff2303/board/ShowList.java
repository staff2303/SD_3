package com.staff2303.board;

import java.sql.SQLException;

public class ShowList {
	static public final int PER_PAGE = 5;
	static int totalPage = 0;
	static int intcount;
	public static int PAGE = 1;
	
	public static void run() {
		try {
			Sql.result = Sql.st.executeQuery("select count(*) from board");
			Sql.result.next();
			intcount = Integer.parseInt(Sql.result.getString("count(*)"));
		} catch (Exception e) {
		}
		if (intcount % PER_PAGE > 0) {
			totalPage = intcount / PER_PAGE + 1;
		} else {
			totalPage = intcount / PER_PAGE;
		}
		if (PAGE <= 0) {
			System.out.println("첫번째 페이지입니다.");
			PAGE = 1;
		} else if (PAGE > totalPage) {
			System.out.println("마지막 페이지입니다.");
			PAGE = PAGE - 1;
		}
		int startindex = (PAGE * PER_PAGE) - PER_PAGE;
		System.out.println("┌─────┭──────────────────────┭────────────┭───────┭──────────────────────┐");
		System.out.println(String.format("| %-3s | %-20s | %-10s | %-5s | %-20s |", Sql.NUM, Sql.TITLE, Sql.WRITER, Sql.HITS, Sql.DATE));
		System.out.println("├─────┼──────────────────────┼────────────┼───────┼──────────────────────┤");
		try {
			Sql.result = Sql.st.executeQuery("select * from board limit " + startindex + "," + PER_PAGE);
			while (Sql.result.next()) {
				String no = Sql.result.getString("b_no");
				String title = Sql.result.getString("b_title");
				String writer = Sql.result.getString("b_writer");
				String hits = Sql.result.getString("b_hits");
				String date = Sql.result.getString("b_date");
				System.out.println(
						String.format("| %-3s | %-20s | %-10s | %-5s | %-20s |", no, title, writer, hits, date));
			}
			System.out.println("└─────┵──────────────────────┵────────────┵───────┵──────────────────────┘");
			System.out.println("[ " + PAGE + " / " + totalPage + " ] [5.다음페이지] [6.이전페이지] [7. 검색]");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
