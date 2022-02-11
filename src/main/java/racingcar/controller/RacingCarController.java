package racingcar.controller;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Count;
import racingcar.domain.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {

    public void run() {
        List<Car> cars = getCars();
        race(cars, getCount());

        OutPutView.printResult(getWinners(cars, getMaxPosition(cars)));
    }

    private List<Car> getCars() {
        return Arrays.stream(InputView.getCarNames())
            .map(carName -> new Car(carName, new RandomMovingPolicy()))
            .collect(toList());
    }

    private Count getCount() {
        return InputView.getCount();
    }

    private void race(List<Car> cars, Count count) {
        OutPutView.printStatusMessage();

        while (count.isPositive()) {
            count.subtract();
            moveCars(cars);
            OutPutView.printStatus(cars);
        }
    }

    private void moveCars(List<Car> cars) {
        cars.forEach(Car::move);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);
    }

    private List<String> getWinners(List<Car> cars, int maxPosition) {
        return cars.stream()
            .filter(car -> maxPosition == car.getPosition())
            .map(Car::getName)
            .collect(toList());
    }
}
