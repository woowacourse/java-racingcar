package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final int MOVE_MIN_VALUE = 4;
    private static final int MAX_RANDOM_VALUE = 10;
    private static final Random random = new Random();

    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void participateInRacing(Car car) {
        this.cars.add(car);
    }

    public int participateSize() {
        return this.cars.size();
    }

    public void race() {
        for (Car car : cars) {
            car.move(isMovable());
        }
    }

    public List<Car> getParticipantCars() {
        return Collections.unmodifiableList(cars);
    }

    private boolean isMovable() {
        int randomNumber = makeRandomNumberBetweenZeroAndNine();
        return randomNumber >= MOVE_MIN_VALUE;
    }

    private int makeRandomNumberBetweenZeroAndNine() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }

    public List<Name> judgeRacingWinners() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        Position position = new Position();
        for (Car car : cars) {
            position.changeIfSmallerThan(car.getPosition());
        }
        return position;
    }
}
