package service;

import domain.Car;
import domain.Cars;
import java.util.ArrayList;
import java.util.List;
import view.InputView;
import view.OutputView;

public class GameService {
    public void startRacing() {
        String carNames = InputView.getCarNames();
        List<String> splitCarNames = InputView.getSplitCarNames(carNames);
        List<Car> cars = generateCars(splitCarNames);

        Cars racingCars = new Cars(cars);
        String counts = InputView.getRacingRounds();
        Integer roundCounts = InputView.getParsedRacingRounds(counts);
        playRacingRound(racingCars, roundCounts);

        int maxDistance = racingCars.getMaxDistance();
        List<Car> winners = racingCars.getWinners(maxDistance);
        OutputView.printWinners(winners);
    }

    private List<Car> generateCars(final List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void playRacingRound(final Cars racingCars, final int roundCounts) {
        List<Car> roundResult;
        OutputView.printResultNotice();
        for (int i = 0; i < roundCounts; i++) {
            roundResult = racingCars.startRounds();
            OutputView.printRoundsResult(roundResult);
        }
    }
}
