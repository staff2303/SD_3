package com.staff2303.board;

import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	static void run() {
		rr: while (true) {
			System.out.println(String.format("%20s", "┌────────────────────┐"));
			System.out.println(String.format("%14s", "JAVA 게시판"));
			System.out.println(String.format("%20s", "└────────────────────┘"));
			System.out.println("[1.게시판 입장]");
			System.out.println("[0.끝내기]");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				BoardMenu.run();
				break;
			case 0:
				break rr;
			default:
				break rr;
			}
		}
	}
}