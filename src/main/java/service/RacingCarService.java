package service;

import domain.Cars;
import util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

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
