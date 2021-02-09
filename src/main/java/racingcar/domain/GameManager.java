package racingcar.domain;

import racingcar.domain.dto.GameManagerRequestDto;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private Cars cars;
    private Round round;
    private Results results;
    private Winners winners;

    public void playGame(GameManagerRequestDto requestDto) {
        String carNames = requestDto.getCarNames();
        this.cars = Cars.from(carNames);
        this.round = Round.from(requestDto.getRound());
        this.results = moveAndGetResults();
        this.winners = Winners.from(this.results.getResults());
    }

    private Results moveAndGetResults() {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < this.round.getCount(); i++) {
            this.cars.tryToMove();
            Result result = this.cars.getResultOfCars();
            results.add(result);
        }
        return Results.from(results);
    }

    public Results getResults() {
        return results;
    }

    public Winners getWinners() {
        return winners;
    }
}
