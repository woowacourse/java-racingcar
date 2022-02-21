package racingcar.view;

import java.util.List;

import racingcar.model.Car;

public class OutputView {
    private static final String RESULT_HEADER_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void printCarsPosition(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printDistance(car);
            System.out.println();
        }
        System.out.println();
    }

    private static void printDistance(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
    }

    public static void printResultMessage() {
        System.out.println(RESULT_HEADER_MESSAGE);
    }

    public static void printWinnerNames(List<String> winners) {
        System.out.println(String.join(", ", winners) + WINNER_MESSAGE);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
