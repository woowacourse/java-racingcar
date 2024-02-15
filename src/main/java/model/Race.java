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
        validateDuplicatedCarName(invalidNames);

        for (String name : invalidNames) {
            cars.add(new Car(new Name(name)));
        }
    }

    private void validateDuplicatedCarName(List<String> inValidNames) {
        Set<String> uniqueNames = new HashSet<>(inValidNames);

        if (uniqueNames.size() != inValidNames.size()) {
            throw new IllegalArgumentException("중복된 이름의 자동차는 사용할 수 없습니다.");
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
