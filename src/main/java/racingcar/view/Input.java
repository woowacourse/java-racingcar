package racingcar.view;

import java.util.Scanner;
import racingcar.util.InputValidator;

public class Input {

    private static final String COMMA_REGEX = ",";

    final private Scanner scanner;
    final private InputValidator inputValidator;

    public Input() {
        scanner = new Scanner(System.in);
        inputValidator = new InputValidator();
    }

    public String[] getNames() {
        String[] names = splitByComma(scanner.nextLine());
        inputValidator.isDuplicate(names);
        return names;
    }

    private String[] splitByComma(String input) {
        inputValidator.isValidPattern(input);
        return input.split(COMMA_REGEX);
    }

    public int inputAttemptCount() {
        String input = scanner.nextLine();
        inputValidator.isNumeric(input);
        int attemptCount = Integer.parseInt(input);
        inputValidator.isNaturalNumber(attemptCount);
        return attemptCount;
    }
}
