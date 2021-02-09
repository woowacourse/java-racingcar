package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Cars;

import java.util.Scanner;
import racingcar.domain.Name;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public static Cars getCars(Scanner scanner) {
        OutputView.printCarNameReadMessage();
        try {
            String carNamesInput = scanner.nextLine();
            String[] carNames = carNamesInput.split(CAR_NAME_DELIMITER);

            List<Name> names = new ArrayList<>();
            for(int i = 0; i < carNames.length; i++){
                names.add(new Name(carNames[i]));
            }
            return new Cars(names);
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
