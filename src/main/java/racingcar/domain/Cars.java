package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    public static final int MOVE_CONDITION = 4;
    public static final int RANDOM_NUMBER_BOUND = 10;

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void startEachRace() {
        cars.stream().filter(this::isMoveCondition).forEach(Car::moveForward);
    }

    private boolean isMoveCondition(Car car) {
        return makeRandom() >= MOVE_CONDITION;
    }

    private int makeRandom() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
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
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.toList());
    }
}
