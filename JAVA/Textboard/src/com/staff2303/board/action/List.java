package com.staff2303.board.action;

import com.staff2303.board.data.Database;
import com.staff2303.board.data.Post;

public class List {
	static final String NUM = "NO";
	static final String title = "Title";
	static final String writer = "Writer";
	static final String date = "Date";

	public static void run() {
		System.out.println(String.format("| %-3s | %-20s | %-10s | %-10s |", NUM, title, writer, date));
		for (Post p : Database.posts) {
			p.showlist();
		}
	}
}
