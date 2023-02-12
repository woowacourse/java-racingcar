package controller;

import domain.Car;
import domain.RacingGame;
import domain.RandomNumberGenerator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

    public void run() {
        final List<String> carNames = inputView.askCarNames();
        racingGame.enrollCars(carNames);
        final int trialCount = inputView.askTrialCount();
        play(trialCount);
        outputView.printWinners(racingGame.getWinnerNames());
    }

    private void play(int racingCount) {
        outputView.printResultMessage();
        showCarsStatus();
        for (int i = 0; i < racingCount; i++) {
            racingGame.race();
            showCarsStatus();
        }
    }

    private void showCarsStatus() {
        final List<Car> carsStatus = racingGame.getCars();
        outputView.printCarsStatus(convertCarsStatus(carsStatus));
    }

    private Map<String, Integer> convertCarsStatus(List<Car> carsStatus) {
        final Map<String, Integer> converted = new LinkedHashMap<>();
        carsStatus.forEach(car -> converted.put(car.getName(), car.getPosition()));
        return converted;
    }
}
