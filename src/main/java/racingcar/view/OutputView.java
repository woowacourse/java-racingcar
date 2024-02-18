package racingcar.view;

import static racingcar.constant.ViewMessage.OUTPUT_EXCEPTION_PREFIX;
import static racingcar.constant.ViewMessage.OUTPUT_ROUND_RESULTS_INTRO;
import static racingcar.constant.ViewMessage.OUTPUT_ROUND_RESULT_FORMAT;
import static racingcar.constant.ViewMessage.OUTPUT_WINNERS;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String MOVEMENT_FORMAT = "-";
    private static final String SEPARATOR = ", ";

    public void printRoundResults(List<Cars> roundResult) {
        System.out.println(OUTPUT_ROUND_RESULTS_INTRO.getMessage());
        roundResult.forEach(this::printRoundResult);
    }

    private void printRoundResult(Cars roundResult) {
        for (Car carPerformance : roundResult.values()) {
            String carName = carPerformance.getName();
            int distance = carPerformance.getMovedDistance();
            String movements = MOVEMENT_FORMAT.repeat(distance);

            System.out.printf(OUTPUT_ROUND_RESULT_FORMAT.getMessage(), carName, movements);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(SEPARATOR, winners);
        System.out.printf(OUTPUT_WINNERS.getMessage(), winnerNames);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(OUTPUT_EXCEPTION_PREFIX.getMessage() + e.getMessage());
    }
}
