package calculator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getValues() {
        System.out.println("식을 입력하세요. (숫자, 문자 사이는 공백으로 구분)");
        return scanner.nextLine();
    }
}
