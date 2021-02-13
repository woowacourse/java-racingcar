package racingGame.domain.game;


import racingGame.domain.racingCar.CarDto;
import racingGame.domain.racingCar.Cars;
import racingGame.domain.racingCar.Name;
import racingGame.domain.validator.RacingGameValidator;

import java.util.List;

public class RacingGame {
    private Cars cars;
    private Rounds rounds;

    public RacingGame(final Cars cars, final Rounds rounds) {
        RacingGameValidator.checkIsValidGame(cars, rounds);

        this.cars = cars;
        this.rounds = rounds;
    }

    public boolean isEnd() {
        return rounds.isEnd();
    }

    public void race() {
        this.cars.tryMoveCars();
        this.rounds.next();
    }

    public List<CarDto> getRaceResults() {
        return cars.getResults();
    }

    public List<Name> getWinners() {
        return cars.getWinnerNames();
    }
}
