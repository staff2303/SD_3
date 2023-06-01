package rcp;

import java.util.Scanner;

public class Game {
	void start() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			//입력
			System.out.println("가위 ~ 바위 ~ 보! [ 종료 ] :");
			String player = sc.nextLine();
			if (player.equals("종료")) {
				break;
			}
			//컴퓨터
			String computer = null;
			int ran = (int) (Math.random() * 3);
			if (ran == 0) {
				computer = "가위";
			} else if (ran == 1) {
				computer = "바위";
			} else if (ran == 2) {
				computer = "보";
			}
			//결과창
			System.out.println("player : " + player);
			System.out.println("computer : " + computer);
			if (player.equals(computer)) {
				System.out.println("비겼다");
			} else if ((player.equals("가위") && computer.equals("보")) || 
					(player.equals("바위") && computer.equals("가위")) ||
					(player.equals("보") && computer.equals("바위"))) {
				System.out.println("이겼다");
			} else {
				System.out.println("졌다");
			}
		}
		System.out.println("게임을 종료합니다.");
	}
}