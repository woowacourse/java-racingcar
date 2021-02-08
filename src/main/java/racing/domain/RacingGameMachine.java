package racing.domain;

import racing.dto.CarDto;

import java.util.List;

public class RacingGameMachine {
    private static final String INVALID_TRY_COUNTS = "게임 시도 회수는 양의 정수여야 합니다.";
    private static final int ZERO = 0;

    private final Cars cars;
    private int tryCounts;

    public RacingGameMachine(Cars cars, int tryCounts) {
        validateTryCounts(tryCounts);
        this.cars = cars;
        this.tryCounts = tryCounts;
    }

    private void validateTryCounts(int tryCounts) {
        if (tryCounts <= ZERO) {
            throw new IllegalArgumentException(INVALID_TRY_COUNTS);
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
