package racingcar.view;

import java.util.Scanner;

import racingcar.util.Validator;

public class InputView {
    Scanner scanner = new Scanner(System.in);

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
