package service;

import domain.Cars;
import util.Exceptions;
import util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public int getCount(String rawCount) {

        int count = Integer.parseInt(rawCount);
        validateInvalidNumber(count);

        return count;
    }

    


    public List<String> getMovement(Cars cars) {
        List<String> movement = new ArrayList<>();

        cars.getCars()
            .forEach(car -> movement.add(car.toString()));

        return movement;
    }

    public void moveCars(Cars cars) {
        cars.getCars()
            .forEach(car -> car.move(RandomNumberGenerator.generate()));
    }
}
