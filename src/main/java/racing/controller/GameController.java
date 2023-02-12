package racing.controller;

import racing.domain.RacingGame;
import racing.util.Converter;
import racing.validate.InputVerifier;
import racing.view.input.InputView;
import racing.view.output.OutputView;

import java.util.List;

public class GameController {
    private final RacingGame racingGame;


    public GameController() {
        this.racingGame = new RacingGame(initializeCarNames(), initializeTryCount());
    }

    private List<String> initializeCarNames() {
        String inputCarName = InputView.inputCarName();
        InputVerifier.validateNameLength(inputCarName);
        return Converter.splitInput(inputCarName);
    }

    private int initializeTryCount() {
        String inputCount = InputView.inputCount();
        InputVerifier.checkInputTypeIsNumber(inputCount);
        return Converter.convertType(inputCount);
    }

    public void run() {
        OutputView.printPhrase();
        int tryCount = racingGame.getTryCount();
        while (tryCount-- > 0) {
            racingGame.move();
            OutputView.printStep(racingGame.getCars());
        }
        OutputView.printFinalResult(racingGame.findWinners());
    }
}
