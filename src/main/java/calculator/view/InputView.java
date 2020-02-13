package calculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputValue() {
        return scanner.nextLine();
    }
}
