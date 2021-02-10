package racingcar.view;

import racingcar.controller.CarController;
import racingcar.domain.Car;

import java.util.List;

public class ResultView {
    private static final String RESULT_HEADER_MESSAGE = "\n실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printProgressResult(final List<Car> cars) {
        OutputView.printMessage(RESULT_HEADER_MESSAGE);
        for (Car car : cars) {
            CarController carController = new CarController(car);
            carController.printCarStatus();
        }
    }

    public static void printFinalResult(final List<String> winnersNames) {
        OutputView.printMessage(String.join(", ", winnersNames) + FINAL_RESULT_MESSAGE);
    }
}