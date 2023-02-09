package racingcar;

import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingGame {

    private static final int RANGE_MAX = 9;
    private static final int RANGE_MIN = 0;

    private final List<Car> cars;
    private final int gameTime;

    private List<String> winners = new ArrayList<>();


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

    public void calculateWinners() {
        Integer max = cars.stream().map(Car::getPosition)
                .max(Comparator.naturalOrder()).orElse(null);
        cars.stream().filter(car -> car.getPosition() == max)
                .forEach(car -> winners.add(car.getName()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getGameTime() {
        return gameTime;
    }

    public List<String> getWinners() {
        return winners;
    }
}
