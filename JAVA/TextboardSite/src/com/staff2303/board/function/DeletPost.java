package com.staff2303.board.function;

import java.sql.SQLException;
import java.util.Scanner;

import com.staff2303.board.BoardMenu;
import com.staff2303.board.Sql;

public class DeletPost {
	static Scanner sc = new Scanner(System.in);

	public static void run() {
		System.out.println("삭제할 글번호를 입력해주세요 : ");
		int del = sc.nextInt();
		try {
			Sql.result = Sql.st.executeQuery("select * from board where b_no = " + String.valueOf(del));
			Sql.result.next();
			String writer = Sql.result.getString("b_writer");
			if (writer.equalsIgnoreCase(BoardMenu.LOGINID) || BoardMenu.ROLE.equals("staff")) {
				Sql.st.executeUpdate("delete from board where b_no = " + String.valueOf(del));
				System.out.println("삭제 완료");
			} else {
				System.out.println("작성자가 아니면 삭제할 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
