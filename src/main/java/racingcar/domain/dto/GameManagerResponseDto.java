package racingcar.domain.dto;

import racingcar.domain.Results;
import racingcar.domain.Winners;

public class GameManagerResponseDto {
    private Results results;
    private Winners winners;

    public GameManagerResponseDto(Results results, Winners winners) {
        this.results = results;
        this.winners = winners;
    }

    public Results getResults() {
        return results;
    }

    public Winners getWinners() {
        return winners;
    }
}
