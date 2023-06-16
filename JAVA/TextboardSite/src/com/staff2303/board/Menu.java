package com.staff2303.board;

import java.util.Scanner;

import com.staff2303.board.member.Login;
import com.staff2303.board.member.Register;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	static void run() {
		rr: while (true) {
			Display.menu();
			System.out.println("[1.로그인]");
			System.out.println("[2.회원가입]");
			System.out.println("[0.끝내기]");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				Login.run();
				break;
			case 2:
				Register.run();
				break;
			case 0:
				break rr;
			default:
				break rr;
			}
		}
	}
}