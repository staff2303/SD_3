package com.staff2303.board;

import java.util.Scanner;

import com.staff2303.board.action.Delete;
import com.staff2303.board.action.List;
import com.staff2303.board.action.Show;
import com.staff2303.board.action.Update;
import com.staff2303.board.action.Write;

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
			List.run();
			System.out.print("[1.글읽기] ");
			System.out.print("[2.글쓰기] ");
			System.out.print("[3.글수정] ");
			System.out.print("[4.글삭제] ");
			System.out.println("[0. 메인메뉴로]");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				Show.run();
				break;
			case 2:
				Write.run();
				break;
			case 3:
				Update.run();
				break;
			case 4:
				Delete.run();
				break;
			case 0:
				break mm;
			default:
				break mm;
			}
		}
	}
}