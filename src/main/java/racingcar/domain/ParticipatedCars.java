package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import racingcar.util.BoundedRandomNumberGenerator;
import racingcar.util.RandomNumberGenerator;
import racingcar.validator.exception.CarNameDuplicationException;

public class ParticipatedCars {
    private static final int START_POSITION = 0;

    private final List<Car> cars;

    public ParticipatedCars(final List<String> carNames) {
        checkCarNameDuplicated(carNames);
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, START_POSITION));
        }
    }

    private static void checkCarNameDuplicated(final List<String> carNames) {
        long count = carNames.stream()
                .distinct()
                .count();
        if (count != carNames.size()) {
            throw new CarNameDuplicationException();
        }
    }

    public void executeCarRacing(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.tryToMoveBy(randomNumberGenerator);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
