package racingcar.domain;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
import racingcar.util.RandomNumberGenerator;
import racingcar.util.StringUtil;
import racingcar.validator.exception.carname.CarNameDuplicationException;
import racingcar.validator.exception.carname.CarNameLineEmptyException;
import racingcar.validator.exception.carname.CarNameNullPointerException;

public class ParticipatedCars {
    private static final int START_POSITION = 0;
    private static final int OPERATING_STANDARD = 4;
    private static String EMPTY_STRING = "";

    private final List<Car> cars;

    private ParticipatedCars(List<Car> cars) {
        this.cars = cars;
    }

    public static ParticipatedCars from(String carNamesLine) {
        List<String> carNames = getCarNamesFrom(carNamesLine);
        List<Car> cars = carNames.stream()
                .map(name -> new Car(name, START_POSITION))
                .collect(Collectors.toList());
        return new ParticipatedCars(cars);
    }

    private static List<String> getCarNamesFrom(String carNamesLine) {
        checkCarNamesLineNotNull(carNamesLine);
        checkCarNamesLineNonEmpty(carNamesLine);
        List<String> carNames = StringUtil.split(carNamesLine);
        checkCarNameDuplicated(carNames);
        return carNames;
    }

    private static void checkCarNamesLineNotNull(String carNamesLine) {
        if (carNamesLine == null) {
            throw new CarNameNullPointerException();
        }
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

    public List<String> getWinnerNames() {
        int fastestPosition = findFastestPosition(cars);
        return cars.stream()
                .filter(car -> car.isSamePositionWith(fastestPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int findFastestPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
