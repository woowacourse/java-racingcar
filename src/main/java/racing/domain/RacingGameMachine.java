package racing.domain;

import racing.domain.number.TryCount;
import racing.view.GameScreen;
import racing.view.dto.CarDto;
import racing.view.dto.WinnersDto;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameMachine {
    private static final int MINIMUM_CAR_COUNTS = 2;

    private final Cars cars;
    private final TryCount tryCount;

    public RacingGameMachine(final Cars cars, final TryCount tryCount) {
        Cars copy = cars.clone();
        validateCars(copy);
        this.cars = copy;
        this.tryCount = tryCount;
    }

    private void validateCars(final Cars cars) {
        if (cars.getSize() < MINIMUM_CAR_COUNTS) {
            throw new IllegalArgumentException("자동차 이름은 1개 이상이어야 합니다");
        }
    }

    public void play() {
        GameScreen gameScreen = new GameScreen();
        gameScreen.showMessage();
        while (tryCount.reduce()){
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
