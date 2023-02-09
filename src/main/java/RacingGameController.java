import domain.Car;
import service.RacingGame;
import service.RandomNumberGenerator;
import ui.InputView;
import ui.OutputView;

import java.util.List;
import java.util.TreeMap;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

    public void run() {
        List<String> carNames = inputView.requestCarNames();
        racingGame.generateCars(carNames);
        int trialCount = inputView.requestTrialCount();
        race(trialCount);
    }

    private void race(int trialCount) {
        showCurrentGameResult();
        for (int i = 0; i < trialCount; i++) {
            racingGame.processAllCars();
            showCurrentGameResult();
        }
    }

    private void showCurrentGameResult() {
        List<Car> gameResult = racingGame.getCars();
        outputView.printGameResult(convertGameResult(gameResult));

    }

    private TreeMap<String, Integer> convertGameResult(List<Car> gameResult) {
        TreeMap<String, Integer> converted = new TreeMap<>();
        gameResult.forEach(car -> converted.put(car.getName(), car.getPosition()));
        return converted;
    }
}
