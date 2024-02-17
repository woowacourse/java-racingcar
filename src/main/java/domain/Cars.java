package domain;

import util.Exceptions;

import java.util.*;

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
        List<Car> winners = cars.stream()
                .sorted(Comparator.comparing(Car::getForward).reversed())
                .takeWhile(car -> car.getForward() == getMaxForward())
                .toList();

        return getWinnerNames(winners);
    }

    private List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        winners.forEach(winner -> winnerNames.add(winner.getName()));

        return winnerNames;
    }

    public int getMaxForward() {
        return cars.stream()
                .max(Comparator.comparing(Car::getForward))
                .orElseThrow()
                .getForward();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
