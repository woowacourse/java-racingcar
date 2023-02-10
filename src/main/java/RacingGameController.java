import domain.Car;
import java.util.LinkedHashMap;
import java.util.List;
import service.RacingGame;
import service.RandomNumberGenerator;
import ui.InputView;
import ui.OutputView;

public class RacingGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingGame racingGame = new RacingGame(new RandomNumberGenerator());

    public void run() {
        List<String> carNames = inputView.askCarNames();
        racingGame.generateCars(carNames);
        int trialCount = inputView.askTrialCount();
        race(trialCount);
        outputView.printWinners(racingGame.decisionWinners());
    }

    private void race(int trialCount) {
        outputView.printResultMessage();
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

    private LinkedHashMap<String, Integer> convertGameResult(List<Car> gameResult) {
        LinkedHashMap<String, Integer> converted = new LinkedHashMap<>();
        gameResult.forEach(car -> converted.put(car.getName(), car.getPosition()));
        return converted;
    }
}
