package view;

import java.util.Scanner;
import view.validation.DigitValidator;
import view.validation.SplitValidator;

public class InputView {
    private static final String COMMA = ",";

    public String readCarNames() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        SplitValidator.validate(input, COMMA);
        return input;
    }

    public int readTryCount() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        DigitValidator.validateIsDigit(input);
        return Integer.parseInt(input);
    }
}
