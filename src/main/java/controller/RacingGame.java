package controller;

import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public void startRacing() {
        String carNames = InputView.getCarNames();
        List<Car> cars = parseCarNames(carNames);

        Cars racingCars = new Cars(cars);
        String roundCounts = InputView.getRacingRounds();
        String roundResults = racingCars.startRounds(roundCounts);
        int maxDistance = racingCars.getMaxDistance();

        OutputView.printResultNotice();
        OutputView.printRoundResult(roundResults);
        OutputView.printWinners(racingCars.getWinners(maxDistance));
    }

    private List<Car> parseCarNames(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
