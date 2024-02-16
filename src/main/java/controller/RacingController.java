package controller;

import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    public void startRacing() {
        String carNames = InputView.getCarNames();
        List<Car> cars = parseCarNames(carNames);

        Cars racingCars = new Cars(cars);
        String roundCounts = InputView.getRacingRounds();
        String roundResults = racingCars.startRounds(roundCounts);

        OutputView.printResultNotice();
        OutputView.printRoundResult(roundResults);
        OutputView.printWinners(racingCars.getWinners());
    }

    private List<Car> parseCarNames(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
