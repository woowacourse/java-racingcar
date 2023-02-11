package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private final static String RESULT = "\n실행 결과";
    private final static String WIN = "가 최종 우승했습니다.";

    static public void printResultMessage() {
        System.out.println(RESULT);
    }

    static public void printRoundResult(List<Car> cars) {
        StringBuilder content = new StringBuilder();
        cars.forEach(car -> addCarResult(content, car));
        System.out.println(content);
    }

    static private void addCarResult(StringBuilder roundResult, Car car) {
        final String DELIMITER = " : ";
        final String CAR_RESULT = car.getName() + DELIMITER + convertDistance(car.getDrivenDistance()) + '\n';
        roundResult.append(CAR_RESULT);
    }

    static private String convertDistance(int distance) {
        final String DISTANCE = "-";
        return DISTANCE.repeat(distance);
    }

    static public void printWinners(List<Car> winners) {
        final String DELIMITER = ", ";
        String message =
            winners.stream().map(Car::getName).collect(Collectors.joining(DELIMITER)) + WIN;
        System.out.println(message);
    }

    static public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
