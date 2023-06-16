package com.staff2303.board.function;

import java.sql.SQLException;
import java.util.Scanner;

import com.staff2303.board.BoardMenu;
import com.staff2303.board.Sql;

public class UpdatePost {
	static Scanner sc = new Scanner(System.in);

	public static void run() {
		System.out.println("수정할 글번호를 입력해주세요:");
		int up = sc.nextInt();
		try {
			Sql.result = Sql.st.executeQuery("select * from board where b_no = " + String.valueOf(up));
			Sql.result.next();
			String writer = Sql.result.getString("b_writer");
			if (writer.equalsIgnoreCase(BoardMenu.LOGINID) || BoardMenu.ROLE.equals("staff")) {
				System.out.println("제목 : ");
				String title = sc.next();
				System.out.println("내용 : ");
				String content = sc.next();
				Sql.st.executeUpdate("update board set b_title='" + title + "', b_content='" + content
						+ "', b_date=now() where b_no=" + String.valueOf(up));
				System.out.println("글수정 완료");
			} else {
				System.out.println("작성자가 아니면 수정할 수 없습니다.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
