package com.staff2303.board.function;

import java.sql.SQLException;
import java.util.Scanner;

import com.staff2303.board.Sql;

public class ShowPost {
	static Scanner sc = new Scanner(System.in);

	public static void run() {
		System.out.print("번호를 입력해주세요 : ");
		int n = sc.nextInt();

		show: while (true) {
			System.out.println("┌──────────────────────┭────────────┭───────┭──────────────────────┐");
			System.out.println(
					String.format("| %-20s | %-10s | %-5s | %-20s |", Sql.TITLE, Sql.WRITER, Sql.HITS, Sql.DATE));
			try {
				Sql.result = Sql.st.executeQuery("select * from board where b_no =" + String.valueOf(n));
				Sql.result.next();
				String title = Sql.result.getString("b_title");
				String writer = Sql.result.getString("b_writer");
				String hits = Sql.result.getString("b_hits");
				String date = Sql.result.getString("b_date");
				String content = Sql.result.getString("b_content");
				System.out.println(String.format("| %-20s | %-10s | %-5s | %-20s |", title, writer, hits, date));
				System.out.println("└──────────────────────┵────────────┵───────┵──────────────────────┘");
				System.out.println("┌──────────────────────────────────────────────────────────────────┐");
				System.out.println(" " + content);
				System.out.println("└──────────────────────────────────────────────────────────────────┘");
				Comment.showcomment(n);
				System.out.println("[1.댓글쓰기] [0.나가기]");
				int i = sc.nextInt();
				switch (i) {
				case 1:
					Comment.writcomment(n);
					break;
				case 0:
					break show;
				default:
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
