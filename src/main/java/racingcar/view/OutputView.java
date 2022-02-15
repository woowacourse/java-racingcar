package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    private static final String COLON = " : ";
    private static final String POSITION_MARKER = "-";
    private static final String RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printCarsPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printCarPosition(Car car) {
        String result = car.getName() + COLON;
        for (int count = 0; count < car.getPosition(); count++) {
            result += POSITION_MARKER;
        }
        System.out.println(result);
    }

    public static void printResultMessage() {
        System.out.println(RESULT_HEADER_MESSAGE);
    }

    public static void printWinners(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + WINNER_MESSAGE);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + errorMessage);
    }
}
