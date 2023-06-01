package com.staff2303.board;

import com.staff2303.board.data.Database;

public class Board {
	public void run() {
		Database.loadDatabase();
		Menu.run();
	}
}