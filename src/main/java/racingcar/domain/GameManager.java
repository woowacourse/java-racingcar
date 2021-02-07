package racingcar.domain;

import racingcar.domain.dto.GameManagerRequestDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    private Cars cars;
    private Round round;

    public void playGame(GameManagerRequestDto requestDto) {
        String[] carNames = requestDto.getCarNames();
        this.cars = Cars.of(carNames);
        this.round = Round.of(requestDto.getRound());
        Results results = moveAndGetResults();
        // results를 활용한 결과 출력
    }

    private Results moveAndGetResults() {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < this.round.getCount(); i++) {
            this.cars.tryToMove();
            Result result = this.cars.getResultOfCars();
            results.add(result);
        }
        return Results.of(results);
    }
}
