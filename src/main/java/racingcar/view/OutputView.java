package racingcar.view;

import racingcar.dto.response.RaceResultResponse;
import racingcar.dto.response.RaceWinnersResponse;

public interface OutputView {
    void printRaceResultHeaderMessage();

    void printRaceResult(RaceResultResponse raceResultResponse);

    void printRaceWinners(RaceWinnersResponse raceWinnersResponse);
}
