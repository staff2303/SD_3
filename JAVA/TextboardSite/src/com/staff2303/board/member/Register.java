package com.staff2303.board.member;

import java.util.Scanner;

import com.staff2303.board.Sql;

public class Register {
	static Scanner sc = new Scanner(System.in);

	public static void run() {
		System.out.println(String.format("%20s", "┌────────────────────┐"));
		System.out.println(String.format("%15s", "Register"));
		System.out.println(String.format("%20s", "└────────────────────┘"));
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		try {
			Sql.result = Sql.st.executeQuery("select count(*) from member where m_id='" + id + "'");
			Sql.result.next();
			String count = Sql.result.getString("count(*)");
			if (count.equals("1")) {
				System.out.println("중복된 아이디 입니다");
			} else {
				Sql.st.executeUpdate("insert into member (m_name, m_id, m_pw, m_date) values ('" + name + "','" + id
						+ "','" + pw + "',now())");
				System.out.println("회원가입 완료!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
