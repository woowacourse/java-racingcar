package racingcar.view.OutputView;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.StringJoiner;

public class ConsoleOutputView implements OutputView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String DISTANCE_SYMBOL = "-";
    private static final String RESULT_DELIMITER = " : ";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ",";
    private static final String NEW_LINE = "\n";

    public void printResultMessage() {
        System.out.println(NEW_LINE + RESULT_MESSAGE);
    }

    @Override
    public void printRoundStatus(List<CarDto> cars) {
        for (CarDto car : cars) {
            System.out.println(String.format("%s : %s", car.carName(), DISTANCE_SYMBOL.repeat(car.distance())));
        }
        System.out.print(NEW_LINE);
    }

    @Override
    public void printWinners(List<CarDto> winners) {
        StringJoiner winnerNames = new StringJoiner(WINNER_DELIMITER);

        for (CarDto winner : winners) {
            winnerNames.add(winner.carName());
        }

        System.out.println(String.format("%s%s", winnerNames, WINNER_MESSAGE));
    }

}
