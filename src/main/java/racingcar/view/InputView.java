package racingcar.view;

import racingcar.util.Validator;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);
    public String[] inputCarName() {
        System.out.println(OutputView.INPUT_CAR_NAME);
        String input = sc.nextLine();
        String[] carNames = Validator.validateCarNames(input);
        return carNames;
    }
}
