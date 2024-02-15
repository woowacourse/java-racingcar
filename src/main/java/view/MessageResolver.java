package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class MessageResolver {

    private static final String WINNER_MESSAGE_POSTFIX = "가 최종 우승했습니다.";

    public String resolveMoveResultMessage(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getCarName() + " : " + resolveCarPositionMessage(car.getPosition()))
                .collect(Collectors.joining("\n")) + "\n";
    }

    private String resolveCarPositionMessage(Integer carPosition) {
        String message = "";
        for (int i = 0; i < carPosition; i++) {
            message += "-";
        }
        return message;
    }

    public String resolveWinnerMessage(List<Car> winners) {
        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", ")) + WINNER_MESSAGE_POSTFIX;
    }
}
