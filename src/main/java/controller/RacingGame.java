package controller;

import domain.Car;
import domain.Cars;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final StringBuilder roundResult = new StringBuilder();


    public void startRacing() {
        String carNames = InputView.getCarNames();
        List<Car> cars = parseCarNames(carNames);
        Cars racingCars = new Cars(cars);

        String rawRoundCounts = InputView.getRacingRounds();
        int roundCount = InputView.parseRoundCounts(rawRoundCounts);

        String roundResults = startRounds(roundCount, racingCars);
        int maxDistance = racingCars.getMaxDistance();

        OutputView.printResultNotice();
        OutputView.printRoundResult(roundResults);
        OutputView.printWinners(racingCars.getWinners(maxDistance));
    }

    private String startRounds(final int roundCounts, final Cars cars) {
        for (int i = 0; i < roundCounts; i++) {
            cars.updateRaceRound();
            roundResult.append(cars.getRoundResult());
            roundResult.append("\n\n");
        }
        return roundResult.toString();
    }

    private List<Car> parseCarNames(final String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
