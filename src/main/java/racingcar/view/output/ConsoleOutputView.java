package racingcar.view.output;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.StringJoiner;

public class ConsoleOutputView implements OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String DISTANCE_SYMBOL = "-";
    private static final String RESULT_DELIMITER = " : ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ",";
    public static final String NEW_LINE = System.lineSeparator();

    public void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    @Override
    public void printRoundStatus(final List<CarDto> cars) {
        cars.forEach(car ->
                System.out.println(car.getCarName() + RESULT_DELIMITER + DISTANCE_SYMBOL.repeat(car.getDistance())));
        System.out.print(NEW_LINE);
    }

    @Override
    public void printWinners(final List<CarDto> winners) {
        final StringJoiner winnerNames = new StringJoiner(WINNER_DELIMITER);
        winners.forEach(winner -> winnerNames.add(winner.getCarName()));
        System.out.println(winnerNames + WINNER_MESSAGE);
    }
}
