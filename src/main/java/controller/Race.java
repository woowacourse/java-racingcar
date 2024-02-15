package controller;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Cars;
import model.Name;
import model.NumberGenerator;
import view.InputView;

public class Race {
    private final NumberGenerator numberGenerator;

    public Race(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    private Cars createCars() {
        String[] carNames = InputView.inputCarNames();
        return Arrays.stream(carNames)
                .map(Name::new)
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }

    private void moveCars(Cars cars) {
        cars.getCars()
                .forEach(car -> {
                    int number = numberGenerator.generateNumber();
                    if (number >= 4) {
                        car.moveForward();
                    }
                });
    }

    private List<String> getWinners(final Cars cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars.getCars()) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
