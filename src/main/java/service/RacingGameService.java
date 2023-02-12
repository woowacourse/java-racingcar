package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.Car;
import domain.Cars;
import utils.constants.ErrorMessages;
import utils.numberGenerator.NumberGenerator;

public class RacingGameService {
    private final Cars cars;

    public RacingGameService(NumberGenerator numberGenerator) {
        this.cars = new Cars(numberGenerator);
    }

    public void createCars(List<String> carNames) {
        validateDuplication(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void move() {
            cars.move();
    }

    public List<String> retrieveMoveResults() {
        return cars.retrieveMoveResults();
    }

    public List<String> calculateWinners() {
        return cars.calculateWinners();
    }

    private void validateDuplication(List<String> carNames) {
        Set<String> carNamesWithoutDuplication = new HashSet<>(carNames);
        if (carNames.size() != carNamesWithoutDuplication.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME.getMessage());
        }
    }
}
