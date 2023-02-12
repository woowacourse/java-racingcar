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
        List<String> carNames = inputView.askCarNames();
        racingGame.enrollCars(carNames);
        int trialCount = inputView.askTrialCount();
        race(trialCount);
        outputView.printWinners(racingGame.getWinners());
    }

    private void race(int trialCount) {
        outputView.printResultMessage();
        showCarsStatus();
        for (int i = 0; i < trialCount; i++) {
            racingGame.race();
            showCarsStatus();
        }
    }

    private void showCarsStatus() {
        List<Car> carsStatus = racingGame.getCars();
        outputView.printCarsStatus(convertCarsStatus(carsStatus));
    }

    private Map<String, Integer> convertCarsStatus(List<Car> carsStatus) {
        Map<String, Integer> converted = new LinkedHashMap<>();
        carsStatus.forEach(car -> converted.put(car.getName(), car.getPosition()));
        return converted;
    }
}
