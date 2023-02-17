package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static final String WINNER_GUIDE_MESSAGE = "가 최종 우승했습니다.";
    public static final String WINNER_DELIMITER = ", ";
    private static final String STATUS_GUIDE_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String CAR_POSITION = "-";

    public static void printPositionGuide() {
        System.out.println();
        System.out.println(STATUS_GUIDE_MESSAGE);
    }

    public static void printPositions(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car);
        }
        System.out.println();
    }

    public static void printPosition(Car car) {
        System.out.print(car.getCarName());
        System.out.print(COLON);

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print(CAR_POSITION);
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.print(String.join(WINNER_DELIMITER, winners));
        System.out.println(WINNER_GUIDE_MESSAGE);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
