package domain;

import dto.CarState;
import dto.RacingStatus;
import exception.ErrorMessage;
import exception.RacingCarGameException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        List<CarState> carStates = new ArrayList<>();
        for (Car car : cars) {
            CarState carState = car.move(randomPowerGenerator.generate());
            carStates.add(carState);
        }
        return new RacingStatus(carStates);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int max = findMaxPosition();
        for (Car car : cars) {
            Optional<String> maxCarName = car.getNameIfMax(max);
            if (maxCarName.isPresent()) {
                winners.add(maxCarName.get());
            }
        }
        return winners;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getPosition())
                .max()
                .orElseThrow(() -> new IllegalStateException());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
