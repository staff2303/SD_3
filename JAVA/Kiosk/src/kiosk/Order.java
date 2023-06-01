package kiosk;

import java.util.ArrayList;

import kiosk.product.Product;

public class Order {
	public static ArrayList<Order> order = new ArrayList<>();
	public Product selectedProduct;
	public String name;
	public int price;

	public Order(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public Order(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}