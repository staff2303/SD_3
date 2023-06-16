package com.staff2303.board.member;

import java.util.Scanner;

import com.staff2303.board.BoardMenu;
import com.staff2303.board.Sql;

public class Login {
	static Scanner sc = new Scanner(System.in);

	public static void run() {
		String login = "";
		String role = "";
		System.out.println(String.format("%20s", "┌────────────────────┐"));
		System.out.println(String.format("%14s", "Login"));
		System.out.println(String.format("%20s", "└────────────────────┘"));
		System.out.print("아이디 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호 : ");
		String pw = sc.nextLine();
		try {
			Sql.result = Sql.st.executeQuery("select * from member where m_id='" + id + "' and m_pw='" + pw + "'");
			Sql.result.next();
			login = Sql.result.getString("m_id");
			role = Sql.result.getString("m_role");
		} catch (Exception e) {
		}
		if (login.equalsIgnoreCase(id)) {
			BoardMenu.LOGINID = login;
			BoardMenu.ROLE = role;
			BoardMenu.run();
		} else {
			System.out.println("로그인실패");
		}
	}
}
