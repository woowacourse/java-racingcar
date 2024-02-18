package controller;

import domain.Car;
import domain.Cars;
import domain.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void startRacing() {
        Cars racingCars = makeCars();

        int roundCount = makeRoundCounts();

        startRounds(roundCount, racingCars);

        printWinners(racingCars);
    }

    private Cars makeCars() {
        List<String> carNames = InputView.getCarNames();

        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
        return new Cars(racingCars);
    }

    private int makeRoundCounts() {
        String rawRoundCounts = InputView.getRacingRounds();
        return InputView.parseRoundCounts(rawRoundCounts);
    }

    private void startRounds(final int roundCounts, final Cars cars) {
        for (int i = 0; i < roundCounts; i++) {
            List<Car> updateRaceRound = cars.updateRaceRound(randomNumberGenerator);
            OutputView.printRoundResult(updateRaceRound);
        }
    }

    private void printWinners(Cars cars) {
        int maxDistance = cars.getMaxDistance();
        OutputView.printResultNotice();
        OutputView.printWinners(cars.getWinners(maxDistance));
    }
}
