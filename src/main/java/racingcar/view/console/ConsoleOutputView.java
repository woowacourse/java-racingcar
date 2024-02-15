package racingcar.view.console;

import racingcar.dto.response.RaceResultResponse;
import racingcar.dto.response.RaceWinnersResponse;
import racingcar.view.OutputView;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printRaceResultHeaderMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printRaceResult(RaceResultResponse raceResultResponse) {
        // pobi: ---
    }

    @Override
    public void printRaceWinners(RaceWinnersResponse raceWinnersResponse) {
        String raceWinners = String.join(", ", raceWinnersResponse.raceWinners());

        System.out.println();
        System.out.printf("%s가 최종 우승했습니다.", raceWinners);
    }
}
