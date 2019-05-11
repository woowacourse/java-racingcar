package stringcalculator;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    static public String inputText() {
        System.out.println("계산식을 입력하세요.");
        return sc.nextLine().trim();
    }
}
