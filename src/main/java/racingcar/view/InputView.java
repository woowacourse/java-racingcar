package racingcar.view;

import racingcar.util.Validator;

import java.util.Scanner;

public class InputView {

    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";
    private final Scanner sc = new Scanner(System.in);
    public String[] inputCarName() {
        System.out.println(OutputView.INPUT_CAR_NAME);
        String input = sc.nextLine();
        String[] carNames = Validator.validateCarNames(input);
        return carNames;
    }

    public int inputGameTime() {
        System.out.println(OutputView.INPUT_TRY_COUNT);
        String input = sc.nextLine();
        int inputNumber = Validator.validateGameTime(input);
        return inputNumber;
    }

    public void printPosition(String name, int position) {
        System.out.print(name + COLON + CAR_POSITION_SIGN.repeat(position));
    }
}
