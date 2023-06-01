package com.staff2303.board.action;

import java.util.Scanner;

import com.staff2303.board.data.Database;

public class Delete {
	public static Scanner sc = new Scanner(System.in);
	static final String title = "Title";
	static final String writer = "Writer";
	static final String date = "Date";

	public static void run() {
		System.out.print("삭제할 글 번호를 입력해주세요 : ");
		int n = sc.nextInt();
		System.out.println(n);
		for (int i = 0; i < Database.posts.size(); i++) {
			if (n == (int) Database.posts.get(i).number) {
				Database.posts.remove(i);
			}
		}
		System.out.println("삭제완료!");
	}
}