package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import racingcar.domain.Cars;
import racingcar.domain.Name;
import racingcar.domain.TryNumber;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public static Cars getCars(final Scanner scanner) {
        OutputView.printCarNameReadMessage();
        try {
            String carNamesInput = scanner.nextLine();
            String[] carNames = carNamesInput.split(CAR_NAME_DELIMITER);
            List<Name> names = new ArrayList<>();
            for (String carName : carNames) {
                names.add(new Name(carName));
            }
            return new Cars(names);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getCars(scanner);
        }
    }

    public static TryNumber getTryNumber(final Scanner scanner) {
        OutputView.printAttemptNumberReadMessage();
        try {
            String attemptNumberInput = scanner.nextLine();
            return new TryNumber(Integer.parseInt(attemptNumberInput));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getTryNumber(scanner);
        }
    }

}
