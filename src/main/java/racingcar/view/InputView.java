package racingcar.view;

import racingcar.util.Validator;

import java.util.Scanner;

public class InputView {

    public String inputCarNames() {
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        Validator.validateNotEmptyInput(carNames);

        return carNames;
    }

    public int inputNumberOfRounds() {
        Scanner scanner = new Scanner(System.in);
        String numberOfRounds = scanner.nextLine();
        Validator.validateNaturalNumber(numberOfRounds);

        return Integer.parseInt(numberOfRounds);
    }
}
