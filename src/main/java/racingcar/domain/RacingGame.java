package racingcar.domain;

import racingcar.dto.CarsResponseDto;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private int round;

    private static final int INIT_ROUND = 1;

    public RacingGame(List<String> names) {
        this.cars = new Cars(names);
        this.round = INIT_ROUND;
    }

    public void playRound() {
        cars.moveCars();
        round++;
    }

    public CarsResponseDto findWinners() {
        List<Car> winners = cars.findWinners();
        return new CarsResponseDto(winners);
    }

    public Cars getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }
}