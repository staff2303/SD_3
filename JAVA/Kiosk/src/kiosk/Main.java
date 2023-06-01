package kiosk;

import java.util.Scanner;

import kiosk.Show.ShowMenu;
import kiosk.Show.Showclear;
import kiosk.Show.Showorder;

public class Main {
	public static int num;
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Addmenu.addproducts();
		mm: while (true) {
			Showclear.run();
			System.out.println("┌─────────────────────────┐");
			System.out.println("│    JAVA 카페 키오스크    │");
			System.out.println("└─────────────────────────┘");
			System.out.println("[ 1.주문 2.결제 3.종료]");
			num = sc.nextInt();
			switch (num) {
			case 1:
				ShowMenu.run();
				break;
			case 2:
				Showclear.run();
				Showorder.show();
				Showorder.summoney();
				break mm;
			case 3:
				break mm;
			default:
				break mm;
			}
		}
	}
}