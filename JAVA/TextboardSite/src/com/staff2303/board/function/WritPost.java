package com.staff2303.board.function;

import java.sql.SQLException;
import java.util.Scanner;

import com.staff2303.board.Sql;

public class WritPost {
	static Scanner sc = new Scanner(System.in);

	public static void run() {
		System.out.println("제목 : ");
		String title = sc.next();
		System.out.println("작성자 : ");
		String writer = sc.next();
		System.out.println("내용 : ");
		String content = sc.next();
		try {
			Sql.st.executeUpdate("insert into board (b_title,b_writer,b_date,b_content,b_hits)" + " values ('" + title
					+ "','" + writer + "',now(),'" + content + "',0)");
			System.out.println("글등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
