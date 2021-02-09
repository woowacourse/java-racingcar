package racingcar.domain;

import racingcar.domain.dto.GameManagerRequestDto;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;

    private Cars cars;
    private Round round;

    public Results playGame(GameManagerRequestDto requestDto) {
        initSet(requestDto);
        return startRace();
    }

    private void initSet(GameManagerRequestDto requestDto) {
        this.cars = Cars.of(requestDto.getCarNames());
        this.round = Round.of(requestDto.getRound());
    }

    private Results startRace() {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < this.round.getCount(); i++) {
            this.cars.tryToMoveCars(createRandomNumbers());
            Result result = this.cars.getResultOfCars();
            results.add(result);
        }
        return Results.of(results);
    }

    private List<Integer> createRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            randomNumbers.add(createRandomNumber());
        }
        return randomNumbers;
    }

    private int createRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
    }
}
