package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getValues() {
        System.out.println("식을 입력하세요");
        return SCANNER.nextLine();
    }
}
