package javaracingcar.domain;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        List<String> names = splitCarNames(carNames);
        validateNonZeroElement(names);
        validateDistinctNames(names);
        this.cars = generateCars(names);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<String> splitCarNames(String names) {
        if (names == null) {
            throw new IllegalArgumentException("null 이 입력되었습니다.");
        }
        return Arrays.asList(names.replaceAll(" ", "").split(","));
    }

    private void validateNonZeroElement(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }
    }

    private void validateDistinctNames(List<String> carNames) {
        if (carNames.stream()
            .distinct()
            .count() != carNames.size()) {
            throw new IllegalArgumentException("중복된 이름이 있습니다.");
        }
    }

    private List<Car> generateCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.generateCar(name));
        }
        return cars;
    }

    public void playMoveOrStop() {
        cars.forEach(car -> car.move(RandomUtils.getSingleDigitNumber()));
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        List<Integer> positions = cars
            .stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
        return Collections.max(positions);
    }
}
