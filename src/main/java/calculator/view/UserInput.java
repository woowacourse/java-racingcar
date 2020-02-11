package calculator.view;

import java.util.Scanner;

public class UserInput {
    static final Scanner scanner = new Scanner(System.in);
    public static String inputExpression() {
        return scanner.nextLine();
    }
}
