package racingcar.view;

import racingcar.util.Validator;

import java.util.Scanner;

import static racingcar.view.OutputConstant.*;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    public String[] inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        String input = scanner.nextLine();
        String[] carNames = Validator.validateCarNames(input);
        return carNames;
    }

    public int inputGameTime() {
        System.out.println(INPUT_TRY_COUNT);
        String input = scanner.nextLine();
        int inputNumber = Validator.validateGameTime(input);
        return inputNumber;
    }
}
