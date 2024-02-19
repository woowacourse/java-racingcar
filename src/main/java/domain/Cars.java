package domain;

import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Cars {

    private final String DUPLICATED_NAME_EXCEPTION = "[ERROR] 자동차 이름은 중복될 수 없습니다.";

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicatedNames(names);
        cars = convertNamesToCars(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION);
        }
    }

    private List<Car> convertNamesToCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public void moveCars() {
        cars.forEach(car -> car.drive(RandomNumberGenerator.generate()));
    }

    public List<String> getCurrentStatus() {
        List<String> currentStatus = new ArrayList<>();

        cars.forEach(car -> {
            currentStatus.add(car.getName() + " : " + "-".repeat(car.getForward()));
        });

        return currentStatus;
    }

    public List<String> findWinners() {
        final int maxForward = getMaxForward();

        List<Car> winners = cars.stream()
                .filter(car -> car.getForward() == maxForward)
                .toList();

        return getWinnerNames(winners);
    }

    private int getMaxForward() {
        return cars.stream()
                .mapToInt(Car::getForward)
                .max()
                .orElseThrow();
    }

    private List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        winners.forEach(winner -> winnerNames.add(winner.getName()));

        return winnerNames;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
