package racing.domain;

import racing.view.GameScreen;
import racing.view.dto.CarDto;
import racing.view.dto.WinnersDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameMachine {
    private static final int ZERO = 0;
    private static final int MINIMUM_CAR_COUNTS = 2;

    private final Cars cars;
    private int tryCounts;

    public RacingGameMachine(Cars cars, int tryCounts) {
        Cars copy = cars.clone();
        validateCars(copy);
        validateTryCounts(tryCounts);
        this.cars = copy;
        this.tryCounts = tryCounts;
    }

    private void validateCars(Cars cars) {
        if (cars.getSize() < MINIMUM_CAR_COUNTS) {
            throw new IllegalArgumentException("자동차 이름은 1개 이상이어야 합니다");
        }
    }

    private void validateTryCounts(int tryCounts) {
        if (tryCounts <= ZERO) {
            throw new IllegalArgumentException("시도횟수는 1회 이상이어야 합니다");
        }
    }

    public void play() {
        GameScreen gameScreen = new GameScreen();
        gameScreen.showMessage();
        while (tryCounts-- > ZERO) {
            cars.race();
            gameScreen.showCarStatus(getCarDtos());
        }

        Winners winners = cars.findWinners();
        gameScreen.showWinners(new WinnersDto(winners.getWinnersName()));
    }

    private List<CarDto> getCarDtos() {
        return cars.getCars().stream()
                .map(car -> CarDto.of(car))
                .collect(Collectors.toList());
    }
}
