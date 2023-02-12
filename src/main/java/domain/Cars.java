package domain;

import constant.ExceptionMessage;
import util.NumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String COMMA = ",";
    private static final String BLANK = " ";

    private final List<Car> cars = new ArrayList<>();

    public Cars(String carsName) {
        List<String> carNames = splitCarName(carsName);
        validDuplication(carNames);

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private List<String> splitCarName(String carsName) {
        return Arrays.asList(carsName.split(COMMA));
    }

    private void validDuplication(List<String> carNames) {
        long duplicationSize = carNames.stream().distinct().count();

        if (carNames.size() != duplicationSize) {
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

    public String getWinners() {
        return cars.stream()
                   .filter(car -> car.isLocationEqual(getMaxLocation()))
                   .map(Car::getName)
                   .collect(Collectors.joining(COMMA + BLANK));
    }

    public int getMaxLocation() {
        return cars.stream()
                   .max(Comparator.comparingInt(Car::getLocation))
                   .get()
                   .getLocation();
    }
}
