package racing.domain;

import racing.domain.dto.CarDto;
import racing.view.GameScreen;

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
        GameScreen gameScreen = new GameScreen();
        gameScreen.showMessage();
        while (tryCounts-- > ZERO) {
            cars.race();
            gameScreen.showCarStatus(getCarDtos());
        }
        Winners winners = cars.findWinners();
        gameScreen.showWinners(winners.getWinnersDto());
    }

    public boolean canPlay() {
        return tryCounts > ZERO;
    }

    private List<CarDto> getCarDtos() {
        return cars.getCarDtos();
    }
}
