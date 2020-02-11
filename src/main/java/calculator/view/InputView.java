package calculator.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String receiveInput() {
        String input = scanner.nextLine();

        if ("".equals(input)) {
            throw new RuntimeException("Input is empty");
        }

        return input;
    }
}
