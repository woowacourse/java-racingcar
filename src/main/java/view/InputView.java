package view;

import java.util.Scanner;

public class InputView {
	public static String input() {
		Scanner sc = new Scanner(System.in);

		System.out.print("계산할 식 입력: ");
		return sc.nextLine();
	}
}
