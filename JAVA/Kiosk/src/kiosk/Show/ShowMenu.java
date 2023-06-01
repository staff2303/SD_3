package kiosk.Show;

import java.util.Scanner;

public class ShowMenu {
	public static int num;
	public static Scanner sc = new Scanner(System.in);

	public static void run() {
		nn: while (true) {
			Showclear.run();
			System.out.println("[ 1.음료 2.샌드위치 3.디저트 4.케이크 5.이전메뉴]");
			num = sc.nextInt();
			switch (num) {
			case 1:
				Showdrink.show();
				break;
			case 2:
				Showsnadwich.show();
				break;
			case 3:
				Showdessert.show();
				break;
			case 4:
				Showcake.show();
				break;
			case 5:
				break nn;
			default:
				break nn;
			}
		}
	}
}
