package service;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class RacingService {
    public void proceedCarRacing() {
        List<String> carNames = getCarNames();
        List<Car> cars = generateCars(carNames);
        Cars racingCars = new Cars(cars);

        Integer roundCounts = getRoundCounts();
        startRacingRounds(racingCars, roundCounts);

        checkRacingWinner(racingCars);
    }

    private List<String> getCarNames() {
        String carNames = InputView.getCarNames();
        return InputView.getSplitCarNames(carNames);
    }

    private List<Car> generateCars(final List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private Integer getRoundCounts() {
        String counts = InputView.getRacingRounds();
        return InputView.getParsedRacingRounds(counts);
    }

    private void startRacingRounds(final Cars racingCars, final int roundCounts) {
        List<Car> roundResult;
        OutputView.printResultNotice();
        for (int i = 0; i < roundCounts; i++) {
            roundResult = racingCars.startRounds();
            OutputView.printRoundsResult(roundResult);
        }
    }

    private void checkRacingWinner(Cars racingCars) {
        int maxDistance = racingCars.getMaxDistance();
        List<Car> winners = racingCars.getWinners(maxDistance);
        OutputView.printWinners(winners);
    }
}
