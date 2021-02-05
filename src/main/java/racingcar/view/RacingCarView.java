package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class RacingCarView {
    private static final String RESULT_HEADER_MESSAGE = "\n실행 결과";
    private static final String FINAL_RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printProgressResult(List<Car> cars) {
        OutputView.printMessage(RESULT_HEADER_MESSAGE);
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    public static void printFinalResult(List<String> winnersNames) {
        System.out.print(String.join(", ", winnersNames) + FINAL_RESULT_MESSAGE);
    }

    private static void printCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        System.out.println(getProgressBarStatus(car.getPosition()));
    }

    private static StringBuilder getProgressBarStatus(int carPosition) {
        StringBuilder progressBarStatus = new StringBuilder();
        for (int i = 0; i < carPosition; ++i) {
            progressBarStatus.append('-');
        }
        return progressBarStatus;
    }
}
