package rcp;

import java.util.Scanner;

public class Game {
	void start() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		while (true) {
			//�Է�
			System.out.println("���� ~ ���� ~ ��! [ ���� ] :");
			String player = sc.nextLine();
			if (player.equals("����")) {
				break;
			}
			//��ǻ��
			String computer = null;
			int ran = (int) (Math.random() * 3);
			if (ran == 0) {
				computer = "����";
			} else if (ran == 1) {
				computer = "����";
			} else if (ran == 2) {
				computer = "��";
			}
			//���â
			System.out.println("player : " + player);
			System.out.println("computer : " + computer);
			if (player.equals(computer)) {
				System.out.println("����");
			} else if ((player.equals("����") && computer.equals("��")) || 
					(player.equals("����") && computer.equals("����")) ||
					(player.equals("��") && computer.equals("����"))) {
				System.out.println("�̰��");
			} else {
				System.out.println("����");
			}
		}
		System.out.println("������ �����մϴ�.");
	}
}