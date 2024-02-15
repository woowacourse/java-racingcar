package racingcar.ui;


import static racingcar.ui.OutputCommand.ERROR_PREFIX;

public class OutputView {
    public static void printInputErrorMessage() {
        System.out.println(ERROR_PREFIX + OutputCommand.INPUT_ERROR_MESSAGE);
    }
}
