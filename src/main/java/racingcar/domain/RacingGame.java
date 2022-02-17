package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.util.RandomUtil;

public class RacingGame {
    private static final String NOTHING_NAME_ERROR_MASSAGE = "자동차 이름들이 존재하지 않음";
    private final List<Car> cars = new ArrayList<>();
    private final List<String> championNames = new ArrayList<>();
    private int rounds;

    public RacingGame(final List<String> names, final int rounds) {
        validateNames(names);
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.rounds = rounds;
    }

    private void validateNames(final List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException(NOTHING_NAME_ERROR_MASSAGE);
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(RandomUtil.generateRandomNumber());
        }
        reduceRounds();
    }

    private void reduceRounds() {
        if (rounds > 0) {
            rounds--;
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getChampionNames() {
        championNames.clear();
        Car firstCar = Collections.max(cars);

        for (Car car : cars) {
            addTieCarName(firstCar, car);
        }

        return championNames;
    }

    private void addTieCarName(Car firstCar, Car car) {
        if (car.isSamePosition(firstCar.getPosition())) {
            championNames.add(car.getName());
        }
    }

    public boolean isFinished() {
        if (rounds == 0) {
            return true;
        }
        return false;
    }
}
