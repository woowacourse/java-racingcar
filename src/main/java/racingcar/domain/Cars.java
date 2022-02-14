package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final int MOVE_CONDITION = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;

    private final List<Car> cars;

    public Cars(String[] carNames) {
        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void startEachRace() {
        for (Car car : cars) {
            if (isMoveCondition()) {
                car.moveForward();
            }
        }
    }

    private boolean isMoveCondition() {
        return makeRandom() >= MOVE_CONDITION;
    }

    private int makeRandom() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public List<Car> findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winnerCars = new ArrayList<>();
        cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .forEach(winnerCars::add);
        return winnerCars;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public int getSize() {
        return cars.size();
    }

    public List<String> getAllPosition() {
        return cars.stream().map(Car::toString).collect(Collectors.toList());
    }
}
