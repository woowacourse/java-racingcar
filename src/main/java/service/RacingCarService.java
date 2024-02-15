package service;

import domain.Car;
import domain.Cars;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

import static util.Exceptions.NUMBER_FORMAT_EXCEPTION;
import static util.Exceptions.NUMBER_RANGE_EXCEPTION;

public class RacingCarService {

    public int getCount(String rawCount) {
        validateNumberFormat(rawCount);

        int count = Integer.parseInt(rawCount);
        validateInvalidNumber(count);

        return count;
    }

    private void validateNumberFormat(String rawCount) {
        try {
            Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void validateInvalidNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public Cars getCars(String rawNames){
        List<String> names = List.of(rawNames.split(","));

        return new Cars(names);
    }

    public List<String> getMovement(Cars cars) {
        List<String> movement = new ArrayList<>();
        cars.getCars().forEach(car -> movement.add(car.toString()));

        return movement;
    }

    public void moveCars(Cars cars) {
        cars.getCars()
            .forEach(car -> car.drive(RandomGenerator.pickRandomNumber()));
    }

    public List<String> findWinners(Cars cars) {
        List<Car> winners =  cars.getCars().stream()
                .sorted(Car::compareTo)
                .takeWhile(car -> car.getForward() == cars.getMaxForward())
                .toList();

        return getWinnerNames(winners);
    }

    private List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        return winnerNames;
    }
}
