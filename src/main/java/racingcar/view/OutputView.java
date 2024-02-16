package racingcar.view;

import racingcar.dto.response.RaceResultsResponse;
import racingcar.dto.response.RaceWinnersResponse;

public interface OutputView {
    void printRaceResults(RaceResultsResponse raceResultsResponse);

    void printRaceWinners(RaceWinnersResponse raceWinnersResponse);
}
