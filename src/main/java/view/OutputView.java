package view;

import static java.text.MessageFormat.format;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String POSITION_MESSAGE_FORMAT = "{0} : {1}\n";
    private static final String POSITION_SYMBOL = "-";
    private static final String POSITION_MESSAGE_DELIMITER = "\n";
    private static final String WINNERS_MESSAGE_FORMAT = "{0}가 최종 우승했습니다.";
    private static final String WINNERS_MESSAGE_DELIMITER = ", ";


    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printPosition(final List<Car> cars) {
        System.out.println(generatePositionMessages(cars));
    }

    private String generatePositionMessages(final List<Car> cars) {
        return cars.stream()
                .map(this::generatePositionMessage)
                .collect(Collectors.joining(POSITION_MESSAGE_DELIMITER));
    }

    private String generatePositionMessage(final Car car) {
        return format(
                POSITION_MESSAGE_FORMAT,
                car.getName(),
                POSITION_SYMBOL.repeat(car.getPosition())
        );
    }

    public void printWinnersMessage(final List<String> winners) {
        String winnersMessage = String.join(WINNERS_MESSAGE_DELIMITER, winners);
        System.out.println(format(WINNERS_MESSAGE_FORMAT, winnersMessage));
    }
}
