package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class MessageResolver {

    private static final String WINNER_MESSAGE_POSTFIX = "가 최종 우승했습니다.";
    public static final String DELIMITER_FOR_WINNERS = ", ";
    public static final String DELIMITER_FOR_MOVE_RESULT = " : ";
    public static final String MOVE_STATEMENT = "-";

    public String resolveMoveResultMessage(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getCarName() + DELIMITER_FOR_MOVE_RESULT + MOVE_STATEMENT.repeat(car.getPosition()))
                .collect(Collectors.joining("\n")) + "\n";
    }

    public String resolveWinnerMessage(List<Car> winners) {
        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(DELIMITER_FOR_WINNERS)) + WINNER_MESSAGE_POSTFIX;
    }
}
