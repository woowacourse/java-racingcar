package racingcar.domain;

import racingcar.dto.CarsResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private int round;

    private static final int INIT_ROUND = 1;

    public RacingGame(List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.cars = new Cars(cars);
        this.round = INIT_ROUND;
    }

    public void playRound() {
        cars.moveCars();
        round++;
    }

    public CarsResponseDto findWinners() {
        return cars.findWinners();
    }

    public CarsResponseDto getCarsResponseDto() {
        return new CarsResponseDto(cars.getCars());
    }

    public int getRound() {
        return round;
    }
}
