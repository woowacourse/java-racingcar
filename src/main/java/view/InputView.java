package view;

import java.util.Scanner;
import view.validation.InputValidator;

public class InputView {

    public String readCarNames() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        InputValidator.validateCarNames(input);
        return input;
    }

    public int readTryCount() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        InputValidator.validateTryCount(input);
        return Integer.parseInt(input);
    }
}
