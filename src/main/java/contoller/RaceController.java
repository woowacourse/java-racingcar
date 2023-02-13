package contoller;

import domain.RandomMovableStrategy;
import java.util.List;
import java.util.function.Supplier;
import service.RacingGame;
import view.InputView;
import view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.racingGame = initRacingGame();
    }

    private RacingGame initRacingGame() {
        final List<String> carNames = repeat(inputView::readCarNames);
        final int roundNum = repeat(inputView::readTrialNum);
        return new RacingGame(new RandomMovableStrategy(), carNames, roundNum);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (Exception e) {
            outputView.printErrorMessage(e);
            return repeat(inputReader);
        }
    }

    public void run() {
        outputView.printStart(racingGame.getCars());
        while (racingGame.isContinue()) {
            racingGame.race();
            outputView.printCarsStatus(racingGame.getCars());
        }
        outputView.printWinners(racingGame.getWinners());
    }
}
