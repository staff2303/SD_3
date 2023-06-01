package kiosk.Show;

import java.util.Scanner;

import kiosk.Addmenu;
import kiosk.Order;
import kiosk.product.Product;
import kiosk.product.Sandwich;

public class Showsnadwich {
	public static Scanner sc = new Scanner(System.in);

	public static void show() {
		ss: while (true) {
			Showclear.run();
			int num = 1;
			System.out.println("=============== 샌드위치 ===============");
			for (Product d : Addmenu.products) {
				if (d instanceof Sandwich) {
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
				Order.order.add(new Order(Addmenu.products.get(4)));
				break;
			case 2:
				Order.order.add(new Order(Addmenu.products.get(5)));
				break;
			case 3:
				Order.order.add(new Order(Addmenu.products.get(6)));
				break;
			case 4:
				Order.order.add(new Order(Addmenu.products.get(7)));
				break;
			default:
				break ss;
			}
		}
	}
}