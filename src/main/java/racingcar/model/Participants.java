package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Participants {

    private static final int MAKE_ONE_DIGIT_MULTIPLIER = 10;

    private final List<Car> cars;

    public Participants(String[] carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }

    public int participateSize() {
        return this.cars.size();
    }

    public void race() {
        for (Car car : cars) {
            car.tryMove(makeRandomNumberBetweenZeroAndNine());
        }
    }

    public List<Car> getParticipantCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findRacingWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPosition))
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
                .max(Car::compareWinnerPosition)
                .orElseThrow(NoSuchElementException::new)
                .getCarPosition();
    }

    private int makeRandomNumberBetweenZeroAndNine() {
        return (int) (Math.random() * MAKE_ONE_DIGIT_MULTIPLIER);
    }
}
