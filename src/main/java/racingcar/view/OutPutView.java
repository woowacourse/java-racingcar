package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutPutView {
    private static final String STATUS_MESSAGE = "\n실행 결과";
    private static final String WINNER_NAME_DELIMITER = ", ";
    private static final String END_MESSAGE = "가 최종 우승했습니다.";

    public static void printStatusMessage() {
        System.out.println(STATUS_MESSAGE);
    }

    public static void printStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(makeCarStatus(car)));
        System.out.println();
    }

    private static String makeCarStatus(Car car) {
        StringBuilder carStatus = new StringBuilder(car.getName());
        carStatus.append(" : ");
        int position = car.getPosition();
        while (position-- > 0) {
            carStatus.append("-");
        }
        return carStatus.toString();
    }

    public static void printResult(List<String> winners) {
        System.out.println(String.join(WINNER_NAME_DELIMITER, winners) + END_MESSAGE);
    }

    public static void printErrorMessage(String message) {
        System.out.println(message + "\n");
    }
}
