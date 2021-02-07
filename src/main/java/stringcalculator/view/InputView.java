package stringcalculator.view;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputFormUser() {
        String input = scanner.nextLine();

        if(input.startsWith("//")) {
            input += System.lineSeparator() + scanner.nextLine();
        }

        return input;
    }
}