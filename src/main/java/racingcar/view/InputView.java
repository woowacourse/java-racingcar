package racingcar.view;

import racingcar.domain.Cars;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public static Cars getCars(Scanner scanner) {
        OutputView.printCarNameReadMessage();
        try {
            String carNamesInput = scanner.nextLine();
            String[] carNames = carNamesInput.split(CAR_NAME_DELIMITER);
            return new Cars(carNames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCars(scanner);
        }
    }

    public static int getAttemptNumber(Scanner scanner) {
        OutputView.printAttemptNumberReadMessage();
        try {
            String attemptNumberInput = scanner.nextLine();
            int attemptNumber = Integer.parseInt(attemptNumberInput);
            validateAttemptNumber(attemptNumber);
            return attemptNumber;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getAttemptNumber(scanner);
        }
    }

    private static void validateAttemptNumber(int attemptNumber) {
        if (attemptNumber <= 0) {
            throw new IllegalArgumentException("[Error] 시도할 횟수는 0보다 커야합니다.\n");
        }
    }

}
