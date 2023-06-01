package com.staff2303.board.action;

import java.util.Scanner;

import com.staff2303.board.data.Database;
import com.staff2303.board.data.Post;

public class Update {
	public static Scanner sc = new Scanner(System.in);
	static final String title = "Title";
	static final String writer = "Writer";
	static final String date = "Date";

	public static void run() {
		System.out.print("수정할 글 번호를 입력해주세요 : ");
		int n = sc.nextInt();
		System.out.println(String.format("| %-20s | %-10s | %-10s |", title, writer, date));
		for (Post p : Database.posts) {
			if (n == (int) p.number) {
				p.showpost();
				System.out.println("수정내용 : ");
				String str = sc.nextLine();
				str = sc.nextLine();
				p.content = str;
			}
		}
		System.out.println("수정완료!");
	}
}
