package com.staff2303.board.function;

import java.sql.SQLException;
import java.util.Scanner;

import com.staff2303.board.Sql;

public class DeletPost {
	static Scanner sc = new Scanner(System.in);
	
	public static void run() {
		System.out.println("삭제할 글번호를 입력해주세요 : ");
		int del = sc.nextInt();
		try {
			Sql.st.executeUpdate("delete from board where b_no=" + String.valueOf(del));
			System.out.println("글삭제 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
