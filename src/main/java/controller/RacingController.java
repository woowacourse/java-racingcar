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

        RacingCars racingCars = createRacingCars(cars);
        Integer roundCounts = InputView.getRacingRounds();
        String roundResults = startRounds(roundCounts, racingCars);

        OutputView.printResultNotice();
        OutputView.printRoundResult(roundResults);
        OutputView.printWinners(racingCars.getWinners());
    }

    private String startRounds(Integer roundCounts, RacingCars racingCars) {
        StringBuilder roundResult = new StringBuilder();
        for (int i = 0; i < roundCounts; i++) {
            racingCars.startRound();
            roundResult.append(racingCars.getRoundResult());
            roundResult.append("\n\n");
        }
        return roundResult.toString();
    }

    private List<Car> parseCarNames(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private RacingCars createRacingCars(List<Car> cars) {
        return new RacingCars(cars);
    }
}
