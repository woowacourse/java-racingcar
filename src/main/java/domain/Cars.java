package domain;

import util.Exceptions;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicatedNames(names);
        cars = convertNamesToCars(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException(Exceptions.DUPLICATED_NAME_EXCEPTION.getMessage());
        }
    }

    private List<Car> convertNamesToCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
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

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
