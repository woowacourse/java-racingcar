package racingcar.view;

import racingcar.util.Validator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String inputCarNames() {
        String carNames = scanner.nextLine();
        Validator.validateNotEmptyInput(carNames);

        return carNames;
    }

    public int inputNumberOfRounds() {
        String numberOfRounds = scanner.nextLine();
        Validator.validateNaturalNumber(numberOfRounds);

        return Integer.parseInt(numberOfRounds);
    }
}
