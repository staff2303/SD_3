package lotto;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
	public static void main(String[] args) {

		int[] lotto = new int[6];
		int[] player = new int[6];
		Random random = new Random();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < player.length; i++) {
			System.out.println((i + 1) + "번째 번호를 입력해주세요");
			player[i] = sc.nextInt();
			if (0 >= player[i] || player[i] > 45) {
				System.out.println("1 ~ 45 번째 번호를 입력해주세요");
				i--;
			} else {
				for (int j = 0; j < i; j++) {
					if (player[i] == player[j]) {
						System.out.println("중복된 숫자입니다");
						i--;
						break;
					}
				}
			}
		}

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = random.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}

		int stack = 0;
		for (int i = 0; i < player.length; i++) {
			if (player[i] == lotto[i]) {
				stack++;
			}
		}
		System.out.println("* 추점번호 : " + Arrays.toString(player));
		System.out.println("* 당첨번호 : " + Arrays.toString(lotto));
		System.out.println("* 맞춘갯수 : " + stack + "개");
	}
}
