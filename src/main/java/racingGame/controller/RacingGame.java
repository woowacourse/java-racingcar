package racingGame.controller;

import java.util.ArrayList;
import java.util.List;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.utils.CarFactory;
import racingGame.view.InputView;
import racingGame.view.OutputView;

public class RacingGame {
    private int maxPosition = 7;

    public void run() {
        int movementNumber;

        Cars cars = new Cars(CarFactory.createByNames(InputView.getCarName()));
        movementNumber = InputView.getMovementNumber();

        for (int i = 0; i < movementNumber; i++) {
            cars.moveCars();
            OutputView.printCars(cars);
        }
        maxPosition = cars.getMaximumPosition();
        OutputView.printWinners(getWinners(cars));
    }

    public List<Car> getWinners(final Cars cars) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars.getCars()) {
            addIfWinner(winners, car);
        }
        return winners;
    }

    private void addIfWinner(List<Car> winners, final Car car) {
        if (car.isWinnerPosition(maxPosition)) {
            winners.add(car);
        }
    }
}
