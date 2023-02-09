package racingcar;

import racingcar.util.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static final int RANGE_MAX = 9;
    private static final int RANGE_MIN = 0;

    private final List<Car> cars;
    private final int gameTime;

    public RacingGame(int gameTime, List<Car> cars) {
        Validator.validateGameTime(gameTime);
        Validator.validateCars(cars);
        this.gameTime = gameTime;
        this.cars = cars;
    }


    public void moveCars() {
        cars.forEach(car -> car.move(generateRandomNumber()));
    }

    private int generateRandomNumber() {
        return (int) ((Math.random() * (RANGE_MAX - RANGE_MIN)) + RANGE_MIN);
    }

    public List<String> calculateWinners() {
        Integer max = cars.stream().map(Car::getPosition)
                .max(Comparator.naturalOrder()).orElse(null);

        return cars.stream().filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getGameTime() {
        return gameTime;
    }
}
