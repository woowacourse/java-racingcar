package domain;

import constant.ExceptionMessage;
import util.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String COMMA = ",";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carsName) {
        List<String> carNames = splitCarName(carsName);

        for (String name : carNames) {
            Name newName = new Name(name);
            validDuplication(newName);
            cars.add(new Car(newName));
        }
    }

    private List<String> splitCarName(String carsName) {
        return Arrays.asList(carsName.split(COMMA));
    }

    private void validDuplication(Name newName) {
        boolean isDuplication = cars.stream()
                                    .anyMatch(car -> car.isDuplicate(newName));

        if (isDuplication) {
            throw new IllegalArgumentException(
                    ExceptionMessage.DUPLICATION_CAR_NAME_MESSAGE.getExceptionMessage());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveForRound(NumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            car.moveByNumber(randomNumberGenerator.generateNumber());
        }
    }

    public List<String> getWinners() {
        return cars.stream()
                   .filter(car -> car.isLocationEqual(getMaxLocation()))
                   .map(Car::getName)
                   .collect(Collectors.toList());
    }

    public int getMaxLocation() {
        return cars.stream()
                   .max(Comparator.comparingInt(Car::getLocation))
                   .orElseThrow(() ->
                           new IllegalArgumentException(ExceptionMessage.GET_MAX_LOCATION_MESSAGE.getExceptionMessage()))
                   .getLocation();
    }
}
