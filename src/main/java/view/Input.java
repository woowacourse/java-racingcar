package view;

import java.util.Scanner;
import utils.Validator;

public class Input {
    private final Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public String getInput() {
        return scanner.nextLine();
    }

    public String[] getCarNames(String input) {
        String[] carNames = input.split(",");
        Validator.checkDuplication(carNames);
        return carNames;
    }

    public int getTryCount(String input) {
        Validator.checkDigits(input);
        int tryCount = Integer.parseInt(input);
        Validator.checkRange(tryCount);
        return tryCount;
    }
}
