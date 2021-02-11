package javaracingcar.domain;

import utils.RandomUtils;

import java.util.List;

public class RacingGame {
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final Cars cars;
    private int trial;

    public RacingGame(List<String> carNames, int trial) {
        this(Cars.createByName(carNames), trial);
    }

    public RacingGame(Cars cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public Cars getCars() {
        return cars;
    }

    public boolean isEnd() {
        return trial == 0;
    }

    public void playOneRound() {
        playMoveOrStop();
        trial--;
    }

    private void playMoveOrStop() {
        cars.toList()
            .forEach(this::playMoveOrStop);
    }

    private void playMoveOrStop(Car car) {
        car.move(generateRandomNumber());
    }

    private int generateRandomNumber() {
        return RandomUtils.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public List<Car> getWinners() {
        return cars.atPosition(cars.getMaxPosition());
    }
}
