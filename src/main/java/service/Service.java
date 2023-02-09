package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.Car;
import domain.Cars;
import domain.Rule;
import utils.RandomNumberGenerator;
import utils.exception.AlreadyDefinedFieldException;

public class Service {
    private final Cars cars = new Cars(new RandomNumberGenerator());
    private Rule rule;

    public void setCars(List<String> carNames) {
        validateDuplication(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void setTrial(Long trial) {
        if (rule == null) {
            rule = new Rule(trial);
            return;
        }

        throw new AlreadyDefinedFieldException();
    }

    public void move() {
        cars.move();
    }

    public Long getTrial() {
        return rule.getTrial();
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
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }
    }
}
