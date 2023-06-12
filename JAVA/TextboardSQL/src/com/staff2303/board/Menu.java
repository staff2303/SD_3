package com.staff2303.board;

import java.util.Scanner;

public class Menu {
	public static Scanner sc = new Scanner(System.in);

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
				Menu.menu();
				break;
			case 0:
				break rr;
			default:
				break rr;
			}
		}
		
	}

	static void menu() {
		mm: while (true) {
			System.out.println(String.format("%20s", "┌────────────────────┐"));
			System.out.println(String.format("%14s", "JAVA 게시판"));
			System.out.println(String.format("%20s", "└────────────────────┘"));
			Sql.showlist();
			System.out.print("[1.글읽기] ");
			System.out.print("[2.글쓰기] ");
			System.out.print("[3.글수정] ");
			System.out.print("[4.글삭제] ");
			System.out.println("[0. 메인메뉴로]");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				Sql.showpost();
				break;
			case 2:
				Sql.writepost();
				break;
			case 3:
				Sql.updatepost();
				break;
			case 4:
				Sql.deletepost();
				break;
			case 0:
				break mm;
			default:
				break mm;
			}
		}
	}
}