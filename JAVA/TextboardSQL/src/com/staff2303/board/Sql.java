package com.staff2303.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sql {
	final String USERNAME = "root";// DBMS접속 시 아이디
	final String PASSWORD = "root";// DBMS접속 시 비밀번호
	final String URL = "jdbc:mysql://localhost:3306/staff_board";
	static Connection con = null;
	static Statement st = null;
	static ResultSet result = null;
	static final String NUM = "NO";
	static final String TITLE = "Title";
	static final String WRITER = "Writer";
	static final String DATE = "Date";
	static final String HITS = "hits";
	public static Scanner sc = new Scanner(System.in);

	void run() {
		dbinit();
		Menu.run();
	}

	private void dbinit() {
		try {
			Sql.con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			Sql.st = con.createStatement();
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
		}
	}
}
