package calculator;

import java.util.Arrays;
import java.util.Scanner;

public class InputHandler {
    static final String ASK_EXPRESSION = "식을 입력해주세요.";

    static Scanner scanner = new Scanner(System.in);

    public static String getInput() {
        System.out.println("식을 입력해주세요.");
        String input = scanner.nextLine();

        try {
            NumericExpression numericExpression = new NumericExpression(input);
            return numericExpression.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInput();
        }
    }


}
