package racingcar.view;

import static racingcar.constant.ViewMessage.OUTPUT_ROUND_RESULTS_INTRO;
import static racingcar.constant.ViewMessage.OUTPUT_ROUND_RESULT_FORMAT;

import java.util.List;
import racingcar.dto.CarPerformance;
import racingcar.dto.RoundResult;

public class OutputView {
    private static final String MOVEMENT_FORMAT = "-";

    public void printRoundResults(List<RoundResult> roundResults) {
        System.out.println(OUTPUT_ROUND_RESULTS_INTRO.getMessage());
        roundResults.forEach(this::printRoundResult);
    }

    private void printRoundResult(RoundResult roundResult) {
        for (CarPerformance carPerformance : roundResult.getCarPerformances()) {
            String carName = carPerformance.getCarName();
            int distance = carPerformance.getDistance();
            String movements = MOVEMENT_FORMAT.repeat(distance);

            System.out.printf(OUTPUT_ROUND_RESULT_FORMAT.getMessage(), carName, movements);
        }
        System.out.println();
    }
}
