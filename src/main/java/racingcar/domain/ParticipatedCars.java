package racingcar.domain;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.StringUtil;
import racingcar.validator.exception.carname.CarNameDuplicationException;
import racingcar.validator.exception.carname.CarNameLineEmptyException;

public class ParticipatedCars {
    private static final int START_POSITION = 0;
    private static final int OPERATING_STANDARD = 4;
    private static String EMPTY_STRING = "";

    private final List<Car> cars;

    public ParticipatedCars(final String carNamesLine) {
        List<String> carNames = getCarNamesFrom(carNamesLine);
        cars = carNames.stream()
                .map(name -> new Car(name, START_POSITION))
                .collect(Collectors.toList());
    }

    private List<String> getCarNamesFrom(String carNamesLine) {
        checkCarNamesLineNonEmpty(carNamesLine);
        List<String> carNames = StringUtil.split(carNamesLine);
        checkCarNameDuplicated(carNames);
        return carNames;
    }

    private static void checkCarNamesLineNonEmpty(String carNamesLine) {
        if (carNamesLine.equals(EMPTY_STRING)) {
            throw new CarNameLineEmptyException();
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

    public void tryToMoveBy(RandomNumberGenerator randomNumberGenerator) {
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
