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

    public void move(Long trial) {
        for (int i = 0; i < trial; i++) {
            cars.move();
        }
    }

    public List<String> getMoveResult() {
        return cars.getResult();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    private void validateDuplication(List<String> carNames) {
        Set<String> carNamesWithoutDuplication = new HashSet<>(carNames);
        if (carNames.size() != carNamesWithoutDuplication.size()) {
            throw new IllegalArgumentException(ErrorMessages.DUPLICATED_NAME.getMessage());
        }
    }
}
