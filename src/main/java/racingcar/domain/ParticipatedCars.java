package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import racingcar.util.RandomNumberGenerator;
import racingcar.validator.exception.CarNameDuplicationException;

public class ParticipatedCars {
    private static final int START_POSITION = 0;
    private static final int OPERATING_STANDARD = 4;

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

    public void tryToDriveBy(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            executeGeneratorToMoveCar(car, randomNumberGenerator);
        }
    }

    private void executeGeneratorToMoveCar(Car car, RandomNumberGenerator randomNumberGenerator) {
        if (randomNumberGenerator.generate() > OPERATING_STANDARD) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
