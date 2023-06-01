package kiosk;

import java.util.ArrayList;

import kiosk.product.Cake;
import kiosk.product.Dessert;
import kiosk.product.Drink;
import kiosk.product.Product;
import kiosk.product.Sandwich;

public class Addmenu {
	public static ArrayList<Product> products = new ArrayList<>();

	public static void addproducts() {
		// 음료
		products.add(new Drink("아이스아메리카노", 2500));
		products.add(new Drink("아이스카라멜마끼아또", 3500));
		products.add(new Drink("아이스카페라떼", 3000));
		products.add(new Drink("아이스모카라떼", 3000));
		// 샌드위치
		products.add(new Sandwich("햄/치즈", 5000));
		products.add(new Sandwich("햄/치즈/베이컨", 5500));
		products.add(new Sandwich("에그마요", 4500));
		products.add(new Sandwich("대만식 연유", 4500));
		// 디저트
		products.add(new Dessert("마카롱", 1500));
		products.add(new Dessert("다쿠아즈", 3000));
		products.add(new Dessert("에그타르트", 2000));
		products.add(new Dessert("허니브레드", 8000));
		// 케이크
		products.add(new Cake("초코케이크", 5000));
		products.add(new Cake("치즈케이크", 5000));
		products.add(new Cake("생크림케이크", 5000));
		products.add(new Cake("티라미수", 5000));
	}
}
