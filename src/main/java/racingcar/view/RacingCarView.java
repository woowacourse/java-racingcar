package racingcar.view;

import racingcar.domain.Car;
import racingcar.view.io.OutputView;

import java.util.List;

public class RacingCarView {
    private static final String RESULT_HEADER_MESSAGE = "\n실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printProgressResult(final List<Car> cars) {
        OutputView.printString(RESULT_HEADER_MESSAGE);
        for (Car car : cars) {
            printCarStatus(car);
        }
        OutputView.printBlankLine();
    }

    public static void printFinalResult(final List<String> winnersNames) {
        OutputView.printString(String.join(", ", winnersNames) + FINAL_RESULT_MESSAGE);
    }

    private static void printCarStatus(final Car car) {
        OutputView.printString(car.getName() + " : " + getProgressBarStatus(car.getPosition()));
    }

    private static String getProgressBarStatus(final int carPosition) {
        StringBuilder progressBarStatus = new StringBuilder();
        for (int i = 0; i < carPosition; ++i) {
            progressBarStatus.append('-');
        }
        return progressBarStatus.toString();
    }
}
