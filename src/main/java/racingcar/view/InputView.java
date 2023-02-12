package racingcar.view;

import racingcar.util.Validator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scan = new Scanner(System.in);

    public String inputCarName() {
        System.out.println(OutputConstant.INPUT_CAR_NAME);
        return scan.nextLine();
    }

    public String inputGameTime() {
        System.out.println(OutputConstant.INPUT_TRY_COUNT);
        return scan.nextLine();
    }

}
