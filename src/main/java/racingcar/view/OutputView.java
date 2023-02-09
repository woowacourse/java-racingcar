package racingcar.view;

import racingcar.constants.InputConstant;
import racingcar.constants.OutputConstant;

public class OutputView {
    public static void printNameInput() {
        System.out.println(InputConstant.CAR_NAME_INPUT_MESSAGE.getMessage());
    }
    public static void printCountInput() {
        System.out.println(InputConstant.TRY_COUNT_INPUT_MESSAGE.getMessage());
    }

    public static void printResultMessage() {
        System.out.println(OutputConstant.RESULT_MESSAGE.getMessage());
    }
}
