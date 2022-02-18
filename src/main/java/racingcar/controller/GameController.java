package racingcar.controller;

import static racingcar.constants.SystemConstants.DELIMITER_COMMA;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_NOT_INTEGER;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private RacingGame racingGame;

    public void run() {
        initGame();
        playGame();
        printGameResult();
    }

    private void initGame() {
        String[] carNames = requestCarNames();
        int totalRounds = requestTotalRounds();

        racingGame = new RacingGame(carNames, totalRounds);
    }

    private String[] requestCarNames() {
        return InputView.requestCarNameInput().split(DELIMITER_COMMA);
    }

    private int requestTotalRounds() {
        return toInt(InputView.requestTotalRoundsInput());
    }

    private int toInt(String inputValue) {
        int totalRounds;

        try {
            totalRounds = Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_NOT_INTEGER);
        }

        return totalRounds;
    }

    private void playGame() {
        OutputView.printRoundResultText();

        while (!racingGame.isOver()) {
            racingGame.playRound();
            OutputView.printRoundResult(racingGame.getCars());
        }
    }

    private void printGameResult() {
        List<Car> winners = racingGame.getWinners();
        OutputView.printWinners(winners);
    }
}
