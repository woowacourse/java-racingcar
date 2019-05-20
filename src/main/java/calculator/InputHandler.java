package calculator;

import java.util.Scanner;

public class InputHandler {
    static final String ASK_EXPRESSION = "식을 입력해주세요.";

    static Scanner scanner = new Scanner(System.in);

    public static NumericExpression getInput() {
        System.out.println(ASK_EXPRESSION);
        String input = scanner.nextLine();

        try {
            return new NumericExpression(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getInput();
        }
    }


}
