package calculator.ui;

import java.util.Scanner;

public class CalculatorInput {
    private static final String INPUT_MESSAGE = "입력: ";

    public static Scanner scanner = new Scanner(System.in);

    public static String userInput() {
        System.out.print(INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
