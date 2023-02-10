package view.output;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT = "\n실행 결과";
    private static final String WIN = "가 최종 우승했습니다.";

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
        final String CAR_RESULT =
            addDuplicateIdentifier(car) + DELIMITER + convertDistance(car.getDrivenDistance()) + '\n';
        roundResult.append(CAR_RESULT);
    }

    static private String addDuplicateIdentifier(Car car) {
        final String DELIMITER = "-";
        final int UNIQUE = 0;
        String name = car.getName();
        int duplicateIdentifier = car.getIdentifier();
        if (duplicateIdentifier != UNIQUE) {
            return name + DELIMITER + duplicateIdentifier;
        }
        return name;
    }

    static private String convertDistance(int distance) {
        final String DISTANCE = "-";
        return DISTANCE.repeat(distance);
    }

    static public void printWinners(List<Car> winners) {
        final String DELIMITER = ", ";
        String message = winners.stream().map(OutputView::addDuplicateIdentifier)
            .collect(Collectors.joining(DELIMITER)) + WIN;
        System.out.println(message);
    }
}
