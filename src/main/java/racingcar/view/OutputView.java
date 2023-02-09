package racingcar.view;

import racingcar.domain.Cars;

import static racingcar.enumType.OutputMessage.RESULT_MESSAGE;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printHeadResult(Cars cars) {
        System.out.println(RESULT_MESSAGE.getValue());
        System.out.println(cars.initStatus());
    }
}
