package racingcar.view;

import racingcar.domain.attemptnumber.AttemptNumber;
import racingcar.utils.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String getCarNames() {
        OutputView.printInputCarNamesMessage();
        return InputValidator.validateInputCarNames(SCANNER.nextLine());
    }

    public static AttemptNumber getAttemptNumber() {
        OutputView.printInputAttemptNumberMessage();
        int attemptNumber = InputValidator.validateInteger(SCANNER.nextLine());
        return new AttemptNumber(attemptNumber);
    }

}