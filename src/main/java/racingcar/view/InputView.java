package racingcar.view;

import racingcar.domain.AttemptNumber;

import java.util.Scanner;

public class InputView {
    private static final String INCORRECT_NUMBER_ERROR = "시도횟수는 숫자여야 합니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String getCarNames() {
        OutputView.printInputCarNamesMessage();
        return SCANNER.nextLine();
    }

    public static AttemptNumber getAttemptNumber() {
        try {
            OutputView.printInputAttemptNumberMessage();
            int attemptNumber = SCANNER.nextInt();
            return new AttemptNumber(attemptNumber);
        } catch (Exception e) {
            throw new IllegalArgumentException(INCORRECT_NUMBER_ERROR);
        }
    }

}