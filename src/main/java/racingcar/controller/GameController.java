package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.ValidatorUtils.validateAndParseBoolean;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;

public class GameController {

    private static final String CAR_NAMES_INPUT_DELIMITER = ",";

    private Game game;

    public void run() {
        do {
            playGame();
        } while (requestNewGameInput());
    }

    public void playGame() {
        initGame();
        playGameUntilEnd();
        printGameResult();
        endGame();
    }

    private void initGame() {
        String[] carNames = requestCarNamesInput();
        int totalRounds = requestTotalRoundsInput();

        game = new Game(carNames, totalRounds);
    }

    private String[] requestCarNamesInput() {
        String carNamesInput = InputView.requestCarNameInput();
        return carNamesInput.split(CAR_NAMES_INPUT_DELIMITER);
    }

    private int requestTotalRoundsInput() {
        String totalRoundsInput = InputView.requestTotalRoundsInput();
        return validateAndParsePositiveInt(totalRoundsInput);
    }

    private void playGameUntilEnd() {
        OutputView.printRoundResultText();

        while (!game.isOver()) {
            game.playRound();
            OutputView.printRoundResult(game.getCars());
        }
    }

    private void printGameResult() {
        List<Car> winners = game.getWinners();
        OutputView.printWinners(winners);
    }

    private void endGame() {
        game.clearCars();
        game = null;
    }

    private boolean requestNewGameInput() {
        String restartGameInput = InputView.requestRestartGameInput();
        return validateAndParseBoolean(restartGameInput);
    }
}
