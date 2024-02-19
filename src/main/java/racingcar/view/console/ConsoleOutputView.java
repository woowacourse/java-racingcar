package racingcar.view.console;

import racingcar.dto.response.RaceResultResponse;
import racingcar.dto.response.RaceWinnersResponse;
import racingcar.view.OutputView;

import java.util.Map;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printRaceResultHeaderMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printRaceResult(final RaceResultResponse raceResultResponse) {
        Map<String, Integer> raceResult = raceResultResponse.raceResult();

        raceResult.forEach((carName, position) -> {
            String currentPosition = "-".repeat(position);
            System.out.printf("%s : %s%n", carName, currentPosition);
        });
        System.out.println();
    }

    @Override
    public void printRaceWinners(final RaceWinnersResponse raceWinnersResponse) {
        String raceWinners = String.join(", ", raceWinnersResponse.raceWinners());

        System.out.printf("%s가 최종 우승했습니다.", raceWinners);
    }
}
