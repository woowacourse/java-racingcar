package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import view.validation.DigitValidator;
import view.validation.SplitValidator;

public class InputView {
    private static final String CAR_NAMES_DELIMITER = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        String carNames = scanner.nextLine();
        SplitValidator.validate(carNames, CAR_NAMES_DELIMITER);

        return Arrays.stream(carNames.split(CAR_NAMES_DELIMITER)).toList();
    }

    public int readTryCount() {
        String tryCount = scanner.nextLine();
        DigitValidator.validateIsDigit(tryCount);

        return Integer.parseInt(tryCount);
    }
}
