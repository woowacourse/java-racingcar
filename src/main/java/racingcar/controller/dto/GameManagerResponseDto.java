package racingcar.controller.dto;

import racingcar.domain.result.Result;
import racingcar.domain.result.Results;

import java.util.List;

public class GameManagerResponseDto {
    private final List<Result> results;
    private final List<String> winners;

    public GameManagerResponseDto(Results results) {
        this.results = results.getResults();
        this.winners = results.findWinners();
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> getWinners() {
        return winners;
    }
}
