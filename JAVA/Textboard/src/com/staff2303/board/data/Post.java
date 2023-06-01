package com.staff2303.board.data;

import java.time.LocalDate;

public class Post {
	static public int num = 0;
	public int number = 0;
	public String title;
	public String content;
	public String writer;
	public String date;

	public Post(String title, String content, String writer) {
		num = num + 1;
		number = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		LocalDate now = LocalDate.now();
		date = now.toString();
	}

	public void showlist() {
		System.out.println(String.format("| %-3s | %-20s | %-10s | %-10s |", number, title, writer, date));
	}

	public void showpost() {
		System.out.println(String.format("| %-20s | %-10s | %-10s |", title, writer, date));
		System.out.println("| content |");
		System.out.println(content);
	}
}
