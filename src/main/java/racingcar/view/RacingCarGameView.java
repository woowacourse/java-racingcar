package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class RacingCarGameView {
    private static final String RESULT_HEADER_MESSAGE = "\n실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public void printProgressResult(final Cars cars) {
        OutputView.printMessage(RESULT_HEADER_MESSAGE);
        for (Car car : cars.getCars()) {
            CarView carView = new CarView();
            carView.printCarStatus(car);
        }
    }

    public void printFinalResult(final List<String> winnersNames) {
        OutputView.printMessage(String.join(", ", winnersNames) + FINAL_RESULT_MESSAGE);
    }
}