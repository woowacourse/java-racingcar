package racingcar.view;

import java.util.Scanner;

import static racingcar.constants.output.RequestOutputMessages.REQUEST_CAR_NAME_INPUT_MESSAGE;
import static racingcar.constants.output.RequestOutputMessages.REQUEST_TOTAL_ROUNDS_INPUT_MESSAGE;

public class InputView {

    private InputView() {
        throw new AssertionError();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static String requestCarNameInput() {
        System.out.println(REQUEST_CAR_NAME_INPUT_MESSAGE);
        return requestUserInput();
    }

    public static String requestTotalRoundsInput() {
        System.out.println(REQUEST_TOTAL_ROUNDS_INPUT_MESSAGE);
        return requestUserInput();
    }

    private static String requestUserInput() {
        return scanner.nextLine();
    }
}
