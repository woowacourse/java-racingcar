package racingcar.controller;

import java.util.List;

import racingcar.model.RacingGame;
import racingcar.model.Winner;
import racingcar.utils.validator.CarNamesValidator;
import racingcar.utils.validator.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private RacingGame racingGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        ready();
        start();
        result();
    }

    private void ready() {
        final String[] carNames = inputCarNames();
        final int tryCount = inputTryCount();

        racingGame = new RacingGame(carNames, tryCount);
    }

    public String[] inputCarNames() {
        try {
            String[] carNames = inputView.inputCarNames();
            CarNamesValidator.validateCarNames(carNames);
            return carNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    public int inputTryCount() {
        try {
            String tryCountInput = inputView.inputTryCount();
            TryCountValidator.validateTryCount(tryCountInput);
            return Integer.parseInt(tryCountInput);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputTryCount();
        }
    }

    private void start() {
        outputView.printResultMessage();

        while (!racingGame.isEnd()) {
            racingGame.race();
            outputView.printResult(racingGame.getCars());
        }
    }

    private void result() {
        Winner winner = new Winner();
        List<String> winners = winner.getWinners(racingGame.getCars());

        outputView.printWinners(winners);
    }
}
