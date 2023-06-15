package com.staff2303.board;

import java.util.Scanner;

import com.staff2303.board.function.DeletPost;
import com.staff2303.board.function.SearchPost;
import com.staff2303.board.function.ShowList;
import com.staff2303.board.function.ShowPost;
import com.staff2303.board.function.UpdatePost;
import com.staff2303.board.function.WritPost;

public class BoardMenu {
	static Scanner sc = new Scanner(System.in);
	
	static void run() {
		mm: while (true) {
			System.out.println(String.format("%20s", "┌────────────────────┐"));
			System.out.println(String.format("%14s", "JAVA 게시판"));
			System.out.println(String.format("%20s", "└────────────────────┘"));
			if (SearchPost.search == null) {
				ShowList.run();
			} else {
				SearchPost.run();
			}
			System.out.print("[1.글읽기] ");
			System.out.print("[2.글쓰기] ");
			System.out.print("[3.글수정] ");
			System.out.print("[4.글삭제] ");
			System.out.println("[0.메인메뉴로]");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				ShowPost.run();
				break;
			case 2:
				WritPost.run();
				break;
			case 3:
				UpdatePost.run();
				break;
			case 4:
				DeletPost.run();
				break;
			case 5:
				if (SearchPost.search == null) {
					ShowList.PAGE = ShowList.PAGE + 1;
				} else {
					SearchPost.PAGE = SearchPost.PAGE + 1;
				}
				break;
			case 6:
				if (SearchPost.search == null) {
					ShowList.PAGE = ShowList.PAGE - 1;
				} else {
					SearchPost.PAGE = SearchPost.PAGE - 1;
				}		
				break;
			case 7:
				SearchPost.run();
				break;
			case 8:
				SearchPost.search = null;
				break;
			case 0:
				break mm;
			default:
				break mm;
			}
		}
	}
}