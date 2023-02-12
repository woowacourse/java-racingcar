package racingcar.domain;

import racingcar.dto.CarStatus;

import java.util.List;

public class RacingGame {
    private static final int TRIES_FINISH_NUMBER = 0;

    private final CarRepository carRepository;
    private final NumberGenerator numberGenerator;
    private int tries;

    public RacingGame(CarRepository carRepository, int tries, NumberGenerator numberGenerator) {
        this.carRepository = carRepository;
        this.tries = tries;
        this.numberGenerator = numberGenerator;
    }

    public List<CarStatus> takeOneTurn() {
        tries--;
        return carRepository.moveCars(numberGenerator);
    }

    public boolean isFinish() {
        return tries == TRIES_FINISH_NUMBER;
    }

    public List<CarStatus> getFinalPosition() {
        return carRepository.getFinalPosition();
    }

    public List<String> getWinnersName() {
        return carRepository.getWinnerCarsName();
    }
}
