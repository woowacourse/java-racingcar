package racingcar.domain;

import racingcar.dto.CarStatus;

import java.util.List;

public class RacingGame {
    private static final int TRIES_FINISH_NUMBER = 0;
    private final CarRepository carRepository;
    private int tries;
    private final NumberGenerator numberGenerator;

    public RacingGame(CarRepository carRepository, int tries, NumberGenerator numberGenerator) {
        this.carRepository = carRepository;
        this.tries = tries;
        this.numberGenerator = numberGenerator;
    }

    public List<CarStatus> takeOneTurn() {
        tries--;
        return carRepository.moveCars(numberGenerator);
    }

    public List<CarStatus> getFinalPosition() {
        return carRepository.getFinalPosition();
    }

    public List<String> getWinnersName() {
        return carRepository.getWinnerCarsName();
    }

    public boolean isFinish() {
        return tries == TRIES_FINISH_NUMBER;
    }
}
