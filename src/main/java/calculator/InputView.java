package calculator;

import java.util.Scanner;

public class InputView {
    private static final String BLANK = " ";

    private static final Scanner scanner = new Scanner(System.in);

    public static String[] getValues() {
        String value = scanner.nextLine();
        return value.split(BLANK);
    }
}
