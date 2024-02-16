package controller;

import domain.Car;
import domain.RacingCars;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingController {
    public void startRacing() {
        String carNames = InputView.getCarNames();
        List<Car> cars = parseCarNames(carNames);

        RacingCars racingCars = new RacingCars(cars);
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
