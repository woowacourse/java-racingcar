package racingcar.domain;

import racingcar.dto.CarStatus;

import java.util.List;

public class RacingGame {
    private static final int TRIES_FINISH_NUMBER = 0;

    private final Cars cars;
    private final NumberGenerator numberGenerator;
    private int tries;

    public RacingGame(Cars cars, int tries, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.tries = tries;
        this.numberGenerator = numberGenerator;
    }

    public List<CarStatus> takeOneTurn() {
        tries--;
        return cars.moveCars(numberGenerator);
    }

    public boolean isFinish() {
        return tries == TRIES_FINISH_NUMBER;
    }

    public List<CarStatus> getFinalPosition() {
        return cars.getFinalPosition();
    }

    public List<String> getWinnersName() {
        return cars.getWinnerCarsName();
    }
}
