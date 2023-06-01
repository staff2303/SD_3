package kiosk.Show;

import java.util.Scanner;

import kiosk.Addmenu;
import kiosk.Order;
import kiosk.product.Drink;
import kiosk.product.Product;

public class Showdrink {
	public static Scanner sc = new Scanner(System.in);

	public static void show() {
		dd: while (true) {
			Showclear.run();
			int num = 1;
			System.out.println("=============== 음료 ===============");
			for (Product d : Addmenu.products) {
				if (d instanceof Drink) {
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
				Order.order.add(new Order(Addmenu.products.get(0)));
				break;
			case 2:
				Order.order.add(new Order(Addmenu.products.get(1)));
				break;
			case 3:
				Order.order.add(new Order(Addmenu.products.get(2)));
				break;
			case 4:
				Order.order.add(new Order(Addmenu.products.get(3)));
				break;
			default:
				break dd;
			}
		}
	}
}