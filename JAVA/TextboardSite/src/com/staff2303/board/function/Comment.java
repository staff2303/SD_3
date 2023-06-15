package com.staff2303.board.function;

import java.sql.SQLException;
import java.util.Scanner;

import com.staff2303.board.Sql;

public class Comment {
	static Scanner sc = new Scanner(System.in);

	static void showcomment(int no) {
		try {
			Sql.result = Sql.st.executeQuery("select * from comments where c_p_no = " + no);
			while (Sql.result.next()) {
				String c_id = Sql.result.getString("c_id");
				String c_text = Sql.result.getString("c_text");
				String c_date = Sql.result.getString("c_date");
				System.out.println("└ [ " + c_id + " ] [ " + c_date + " ] " + c_text);
			}
		} catch (Exception e) {
		}
	}

	static void writcomment(int no) {
		System.out.println("작성자 : ");
		String writer = sc.next();
		System.out.println("내용 : ");
		String ment = sc.next();
		try {
			Sql.st.executeUpdate("insert into comments (c_p_no, c_id, c_text, c_date) values (" + no + ",'" + writer + "','" + ment + "',now())");
			System.out.println("댓글등록 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
