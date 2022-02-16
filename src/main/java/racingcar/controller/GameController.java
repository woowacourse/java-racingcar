package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.MoveStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private Count count;
    private final MoveStrategy moveStrategy;

    public CarController(final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void run() {
        cars = generateCars();
        count = getCountFromUser();

        playGame();
        showResult();
    }

    private void showResult() {
        OutputView.printWinners(cars.findWinners());
    }

    private Cars generateCars() {
        try {
            String carsNames = InputView.getCarNames();
            List<Car> cars = Arrays.stream(carsNames.split(","))
                .map(CarName::new)
                .map(Car::new)
                .collect(Collectors.toList());
            return new Cars(cars, moveStrategy);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateCars();
        }
    }

    private void playGame() {
        OutputView.printResult(cars.get());
        for (int i = 0; i < count.get(); i++) {
            cars.attemptToMoveCars();
            OutputView.printResult(cars.get());
        }
    }

    private Count getCountFromUser() {
        try {
            return new Count(InputView.getCount());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }
}
