package racingcar.view;

import racingcar.util.Validator;

import java.util.Scanner;

public class InputView {
    private final Scanner scan = new Scanner(System.in);

    public String[] inputCarName() {
        System.out.println(OutputConstant.INPUT_CAR_NAME);
        String input = scan.nextLine();
        String[] carNames = Validator.validateCarNames(input);
        return carNames;
    }

    public int inputGameTime() {
        System.out.println(OutputConstant.INPUT_TRY_COUNT);
        String input = scan.nextLine();
        int inputNumber = Validator.validateGameTime(input);
        return inputNumber;
    }

}
