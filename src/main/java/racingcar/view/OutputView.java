package racingcar.view;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.PositionOfCar;

public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String POSITION_MESSAGE_FORMAT = "{0} : {1}";
    private static final String POSITION_SYMBOL = "-";
    private static final String POSITION_MESSAGE_DELIMITER = "\n";
    private static final String WINNERS_MESSAGE_FORMAT = "{0}가 최종 우승했습니다.";
    private static final String WINNERS_MESSAGE_DELIMITER = ", ";
    private static final String ERROR_MESSAGE = "[ERROR] ";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printPosition(final List<PositionOfCar> positionOfCars) {
        System.out.println(generatePositionMessages(positionOfCars) + POSITION_MESSAGE_DELIMITER);
    }

    private String generatePositionMessages(final List<PositionOfCar> positionOfCars) {
        return positionOfCars.stream()
                .map(this::generatePositionMessage)
                .collect(Collectors.joining(POSITION_MESSAGE_DELIMITER));
    }

    private String generatePositionMessage(final PositionOfCar positionOfCar) {
        return format(
                POSITION_MESSAGE_FORMAT,
                positionOfCar.getCarName(),
                POSITION_SYMBOL.repeat(positionOfCar.getPosition())
        );
    }

    public void printWinnersMessage(final List<String> winners) {
        final String winnersMessage = String.join(WINNERS_MESSAGE_DELIMITER, winners);
        System.out.println(format(WINNERS_MESSAGE_FORMAT, winnersMessage));
    }

    public void printErrorMessage(final String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
