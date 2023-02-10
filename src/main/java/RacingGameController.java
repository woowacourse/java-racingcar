import domain.Car;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import service.RacingGame;
import service.RandomNumberGenerator;
import ui.InputView;
import ui.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingGame = new RacingGame(new RandomNumberGenerator());
    }

    public void run() {
        List<String> carNames = inputView.requestCarNames();
        racingGame.generateCars(carNames);
        int trialCount = inputView.requestTrialCount();
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

    private Map<String, Integer> convertGameResult(List<Car> gameResult) {
        LinkedHashMap<String, Integer> converted = new LinkedHashMap<>();
        gameResult.forEach(car -> converted.put(car.getName(), car.getPosition()));
        return converted;
    }
}
