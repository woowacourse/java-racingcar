package view;

import java.util.Scanner;
import view.validation.InputValidator;

public class InputView {

    public String readCarNames() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        InputValidator.validateComma(input);
        return input;
    }
}
