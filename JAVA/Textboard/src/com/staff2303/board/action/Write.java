package com.staff2303.board.action;

import java.util.Scanner;

import com.staff2303.board.data.Database;
import com.staff2303.board.data.Post;

public class Write {
	public static Scanner sc = new Scanner(System.in);

	public static void run() {
		String title;
		String content;
		String writer;

		System.out.println("글쓴이");
		writer = sc.nextLine();
		System.out.println("제목 (20글자내)");
		title = sc.nextLine();
		System.out.println("내용");
		content = sc.nextLine();

		Post p = new Post(title, content, writer);
		Database.posts.add(p);
		System.out.println("작성완료!");
	}
}
