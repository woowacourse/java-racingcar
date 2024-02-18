package domain;

import dto.CarState;
import dto.RacingStatus;
import exception.ErrorMessage;
import exception.RacingCarGameException;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private final RandomPowerGenerator randomPowerGenerator;

    public Cars(List<Car> cars, RandomPowerGenerator randomPowerGenerator) {
        this.cars = cars;
        this.randomPowerGenerator = randomPowerGenerator;
    }

    public static Cars from(List<String> carNames) {
        validateUniqueName(carNames);
        List<Car> cars = convertToCarList(carNames);
        return new Cars(cars, new RandomPowerGenerator());
    }

    public static Cars from(List<String> carNames, RandomPowerGenerator randomPowerGenerator) {
        validateUniqueName(carNames);
        List<Car> cars = convertToCarList(carNames);
        return new Cars(cars, randomPowerGenerator);
    }

    private static List<Car> convertToCarList(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(new CarName(name)))
                .toList();
    }

    private static void validateUniqueName(List<String> names) {
        if (isDuplicatedName(names)) {
            throw RacingCarGameException.from(ErrorMessage.DUPLICATED_NAME_ERROR);
        }
        if (isEmptyNames(names)) {
            throw RacingCarGameException.from(ErrorMessage.INVALID_NAME_ERROR);
        }
    }

    private static boolean isEmptyNames(List<String> names) {
        return names.isEmpty();
    }

    private static boolean isDuplicatedName(List<String> names) {
        return getDistinctCount(names) != names.size();
    }

    private static int getDistinctCount(List<String> names) {
        return (int) names.stream()
                .distinct()
                .count();
    }

    public RacingStatus race() {
        List<CarState> carStates = cars.stream().map(car -> car.move(randomPowerGenerator.generate())).toList();
        return new RacingStatus(carStates);
    }

    public List<String> getWinners() {
        return cars.stream().filter(car -> car.getPosition() == findMaxPosition()).map(Car::getName).toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
