package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.ParseUtils.toInt;
import static racingcar.util.SplitUtils.splitByComma;

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
        return splitByComma(InputView.requestCarNameInput());
    }

    private int requestTotalRounds() {
        return toInt(InputView.requestTotalRoundsInput());
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
