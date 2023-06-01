package kiosk.Show;

import java.io.IOException;

import kiosk.Order;

public class Showorder {

	public static void show() {
		System.out.println("============= 주문내역 =============");
		for (Order o : Order.order) {
			System.out.println(o.selectedProduct.name + " " + o.selectedProduct.price + "원");
		}
		System.out.println("===================================");
	}

	static int money;

	public static void summoney() {
		for (Order o : Order.order) {
			money += o.selectedProduct.price;
		}
		System.out.println("============= 총 금액 =============");
		System.out.println("합계 : " + money + " 원");
		System.out.println("===================================");
		System.out.println("enter : 종료");
		 try {
		       System.in.read();
		     } catch (IOException e) { }
	}
}