package racingcar.view;

import static racingcar.constant.ViewMessage.OUTPUT_EXCEPTION_PREFIX;
import static racingcar.constant.ViewMessage.OUTPUT_ROUND_RESULTS_INTRO;
import static racingcar.constant.ViewMessage.OUTPUT_ROUND_RESULT_FORMAT;
import static racingcar.constant.ViewMessage.OUTPUT_WINNERS;

import java.util.List;
import racingcar.dto.CarPerformance;
import racingcar.dto.RoundResult;

public class OutputView {
    private static final String MOVEMENT_FORMAT = "-";
    private static final String SEPARATOR = ", ";

    public void printRoundResults(List<RoundResult> roundResults) {
        System.out.println(OUTPUT_ROUND_RESULTS_INTRO.getMessage());
        roundResults.forEach(this::printRoundResult);
    }

    private void printRoundResult(RoundResult roundResult) {
        for (CarPerformance carPerformance : roundResult.carPerformances()) {
            String carName = carPerformance.carName();
            int distance = carPerformance.distance();
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
