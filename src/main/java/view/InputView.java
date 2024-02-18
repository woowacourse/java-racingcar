package view;

import java.util.Scanner;
import util.StringConvertor;
import view.validation.DigitValidator;
import view.validation.SplitValidator;

public class InputView {

    public String readCarNames() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        SplitValidator.validate(input);
        return input;
    }

    public int readTryCount() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        DigitValidator.validateIsDigit(input);
        return StringConvertor.convertToInt(input);
    }
}
