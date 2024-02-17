package service;

import domain.Cars;
import util.Exceptions;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException(Exceptions.NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private void validateInvalidNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(Exceptions.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public Cars makeCars(String rawNames){
        List<String> names = List.of(rawNames.split(","));

        return new Cars(names);
    }

    public List<String> getCurrentStatus(Cars cars) {
        List<String> currentStatus = new ArrayList<>();

        cars.getCars().forEach(car -> {
            currentStatus.add(car.getName() + " : " + "-".repeat(car.getForward()));
        });

        return currentStatus;
    }

    public void moveCars(Cars cars) {
        cars.getCars()
            .forEach(car -> car.drive(RandomGenerator.pickRandomNumber()));
    }
}
