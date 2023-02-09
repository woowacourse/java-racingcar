package racingcar.view;

import racingcar.domain.Cars;

import static racingcar.enumType.OutputMessage.RESULT_MESSAGE;
import static racingcar.enumType.OutputMessage.WINNER_MESSAGE;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printHeadResult(Cars cars) {
        System.out.println(RESULT_MESSAGE.getValue());
        System.out.println(cars.initStatus());
    }

    public static void printFinalResult(String winners) {
        System.out.println("\n" + winners + WINNER_MESSAGE.getValue());
    }
}
