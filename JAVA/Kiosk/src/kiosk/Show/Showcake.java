package kiosk.Show;

import java.util.Scanner;

import kiosk.Addmenu;
import kiosk.Order;
import kiosk.product.Cake;
import kiosk.product.Product;

public class Showcake {
	public static Scanner sc = new Scanner(System.in);

	public static void show() {
		cc: while (true) {
			Showclear.run();
			int num = 1;
			System.out.println("=============== 케이크 ===============");
			for (Product d : Addmenu.products) {
				if (d instanceof Cake) {
					System.out.println(num + " : " + d.name + " " + d.price + "원");
					num++;
				}
			}
			System.out.println(num + " : 이전메뉴");
			System.out.println("===================================");
			System.out.println(" 주문하실 제품의 번호를 입력해주세요 ");
			Showorder.show();
			int i = sc.nextInt();
			switch (i) {
			case 1:
				Order.order.add(new Order(Addmenu.products.get(12)));
				break;
			case 2:
				Order.order.add(new Order(Addmenu.products.get(13)));
				break;
			case 3:
				Order.order.add(new Order(Addmenu.products.get(14)));
				break;
			case 4:
				Order.order.add(new Order(Addmenu.products.get(15)));
				break;
			default:
				break cc;
			}
		}
	}
}