package com.staff2303.board;

public class Display {
	public static void menu() {
		System.out.println(String.format("%20s", "┌────────────────────┐"));
		System.out.println(String.format("%14s", "JAVA 게시판"));
		System.out.println(String.format("%20s", "└────────────────────┘"));
		if (BoardMenu.LOGINID != null) {
			System.out.println("[ " + BoardMenu.LOGINID + " 님 환영합니다! ] [ 등급 : " + BoardMenu.ROLE + " ]");
		}
	}
}
