package service;

import domain.Cars;
import util.Exceptions;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public int getCount(String rawCount) {

        int count = Integer.parseInt(rawCount);
        validateInvalidNumber(count);

        return count;
    }

    private void validateInvalidNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(Exceptions.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }


    public List<String> getMovement(Cars cars) {
        List<String> movement = new ArrayList<>();

        cars.getCars()
            .forEach(car -> movement.add(car.toString()));

        return movement;
    }

    public void moveCars(Cars cars) {
        cars.getCars()
            .forEach(car -> car.move(RandomGenerator.pickRandomNumber()));
    }
}
