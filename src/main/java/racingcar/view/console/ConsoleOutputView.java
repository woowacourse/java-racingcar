package racingcar.view.console;

import java.util.List;
import java.util.Map;
import racingcar.dto.response.RaceResultsResponse;
import racingcar.dto.response.RaceWinnersResponse;
import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {
    private static final String RACE_RESULT_FORMAT = "%s : %s%n";

    @Override
    public void printRaceResults(final RaceResultsResponse raceResultsResponse) {
        List<Map<String, Integer>> raceResults = raceResultsResponse.raceResults();

        System.out.println();
        System.out.println("실행 결과");
        raceResults.forEach(this::printRaceResult);
    }

    private void printRaceResult(Map<String, Integer> raceResult) {
        raceResult.forEach((carName, position) -> {
            String currentPosition = "-".repeat(position);
            System.out.printf(RACE_RESULT_FORMAT, carName, currentPosition);
        });
        System.out.println();
    }

    @Override
    public void printRaceWinners(final RaceWinnersResponse raceWinnersResponse) {
        String raceWinners = String.join(", ", raceWinnersResponse.raceWinners());

        System.out.printf("%s가 최종 우승했습니다.", raceWinners);
    }
}
