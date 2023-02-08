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
}
