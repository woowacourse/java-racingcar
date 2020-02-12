package calculator.view;

import java.util.Scanner;

public class UserInput {
    static final Scanner scanner = new Scanner(System.in);
    static final String INPUTMESSAGE = "수식을 입력하세요: ";

    public static String inputExpression() {
        System.out.println(INPUTMESSAGE);
        return scanner.nextLine();
    }
}
