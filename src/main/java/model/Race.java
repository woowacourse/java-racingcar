package model;

import static utils.RandomNumberGenerator.generateRandomNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import utils.Convertor;

public class Race {
    private final List<Car> cars;

    public Race(String inValidNameStr) {
        cars = new ArrayList<>();
        List<String> invalidNames = Convertor.convertStringToList(inValidNameStr);
        validate(invalidNames);

        for (String name : invalidNames) {
            cars.add(new Car(new Name(name)));
        }
    }

    private void validate(List<String> invalidNames) {
        validateDuplicatedCarName(invalidNames);
        validateMinimumNumberOfCars(invalidNames);
    }

    private void validateDuplicatedCarName(List<String> invalidNames) {
        Set<String> uniqueNames = new HashSet<>(invalidNames);

        if (uniqueNames.size() != invalidNames.size()) {
            throw new IllegalArgumentException("중복된 이름의 자동차는 사용할 수 없습니다.");
        }
    }

    private void validateMinimumNumberOfCars(List<String> invalidNames) {
        if (invalidNames.size() < 2) {
            throw new IllegalArgumentException("레이스에 참여하는 자동차는 최소 2대 이상이어야 합니다.");
        }
    }

    public void oneGame() {
        for (Car car : cars) {
            executeRandomMove(car, generateRandomNumber());
        }
    }

    private static void executeRandomMove(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.move();
        }
    }

    public List<String> selectWinners() {
        Collections.sort(cars);
        Car winner = cars.get(0);

        return cars.stream()
                .filter(car -> winner.showDistance().length() == car.showDistance().length())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
