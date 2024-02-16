package view;

import java.util.Scanner;
import view.validation.DigitValidator;
import view.validation.SplitValidator;

public class InputView {

    public String readCarNames() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        SplitValidator.validate(input);
        return input;
    }

    public int readRap() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        DigitValidator.validateIsDigit(input);
        return Integer.parseInt(input);
    }
}
