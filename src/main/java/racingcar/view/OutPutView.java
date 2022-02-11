package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutPutView {
    private static final String STATUS_MESSAGE = "실행 결과";
    public static final String STATUS_FORMAT = " " + ":" + " ";
    private static final String POSITION_FORMAT = "-";
    public static final String RESULT_DELIMITER = ", ";
    public static final String RESULT_MESSAGE = "가 최종 우승했습니다.";

    public static void printStatusMessage() {
        System.out.println();
        System.out.println(STATUS_MESSAGE);
    }

    public static void printStatus(List<Car> cars) {
        cars.forEach(car -> System.out.println(makeCarStatus(car)));
        System.out.println();
    }

    private static String makeCarStatus(Car car) {
        StringBuilder carStatus = new StringBuilder(car.getName() + STATUS_FORMAT);
        int position = car.getPosition();

        while (position-- > 0) {
            carStatus.append(POSITION_FORMAT);
        }
        return carStatus.toString();
    }

    public static void printResult(List<String> winners) {
        System.out.println(String.join(RESULT_DELIMITER, winners) + RESULT_MESSAGE);
    }
}
