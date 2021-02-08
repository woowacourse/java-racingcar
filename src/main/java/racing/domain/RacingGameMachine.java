package racing.domain;

import racing.dto.CarDto;

import java.util.List;

public class RacingGameMachine {
    private static final int ZERO = 0;

    private final Cars cars;
    private int tryCounts;

    public RacingGameMachine(Cars cars, int tryCounts) {
        this.cars = cars;
        this.tryCounts = tryCounts;
        validateTryCounts();
    }

    private void validateTryCounts() {
        if (tryCounts <= ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public void play() {
        tryCounts--;
        cars.race();
    }

    public boolean canPlay() {
        return tryCounts > ZERO;
    }

    public List<String> findWinnerNames() {
        return cars.findWinnerNames();
    }

    public List<CarDto> getCarDtos() {
        return cars.getCarDtos();
    }
}
