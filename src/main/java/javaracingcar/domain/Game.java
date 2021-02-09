package javaracingcar.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final int CAR_MOVES = 4;

    private final List<Car> cars;
    private int trial;

    private Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }
    public List<String> getCarNames() {
        return cars.stream()
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTrial() {
        return trial;
    }

    public static Game init(List<String> carNames, int trial) {
        validateNonZeroElement(carNames);
        validateDistinctNames(carNames);
        return new Game(generateCars(carNames), trial);
    }

    private static void validateNonZeroElement(List<String> carNames) {
        if (carNames.size() < 1) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }
    }

    private static void validateDistinctNames(List<String> carNames) {
        if (carNames.stream()
                    .distinct()
                    .count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    public static List<Car> generateCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.generateCar(name));
        }
        return cars;
    }

    public void playMoveOrStop() {
        cars.forEach(Game::playMoveOrStop);
    }

    private static void playMoveOrStop(Car car) {
        if (RandomUtils.getSingleDigitNumber() >= CAR_MOVES) {
            car.move();
        }
    }

    public void reduceOneTrial() {
        trial--;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isTheSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        List<Integer> positions = cars
                .stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
        return Collections.max(positions);
    }

    public boolean isEnd() {
        return trial == 0;
    }
}
