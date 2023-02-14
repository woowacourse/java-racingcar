package controller;

import domain.Car;
import domain.Cars;
import domain.GameCount;
import domain.PowerGenerator;
import util.CarNamesDivider;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.*;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final CarNamesDivider carNamesDivider;

    public RacingController() {
        inputView = new InputView(System.in);
        outputView = new OutputView();
        carNamesDivider = new CarNamesDivider();
    }

    public void run() {
        String carNames = inputView.requestCarNames();
        List<String> carNamesByDivider = carNamesDivider.divideCarNames(carNames);
        List<Car> inputCars = carNamesByDivider.stream()
                .map(Car::new)
                .collect(toList());
        Cars cars = new Cars(inputCars);
        GameCount gameCount = new GameCount(inputView.requestNumberOfTimes());
        progress(cars, gameCount);
        finish(cars);
    }

    private void progress(Cars cars, GameCount gameCount) {
        outputView.printResultHeader();
        while (gameCount.isGameProgress()) {
            gameCount.proceedOnce();
            moveAllCar(cars);
        }
    }

    private void moveAllCar(Cars cars) {
        cars.moveAll(new PowerGenerator(new Random()));
        outputView.printResult(cars.getCars());
    }

    private void finish(Cars cars) {
        outputView.printWinners(cars.getWinners());
    }

}