package racing.domain;

import racing.view.GameScreen;
import racing.view.dto.CarDto;
import racing.view.dto.WinnersDto;

import java.util.List;
import java.util.stream.Collectors;

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
