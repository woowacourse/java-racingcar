package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.ParseUtils.toInt;
import static racingcar.util.SplitUtils.splitByComma;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;
import static racingcar.util.ValidatorUtils.validatePositiveInt;

public class GameController {

    private RacingGame racingGame;

    public void run() {
        initGame();
        playGame();
        printGameResult();
    }

    private void initGame() {
        String[] carNames = requestCarNamesInput();
        int totalRounds = requestTotalRoundsInput();

        racingGame = new RacingGame(carNames, totalRounds);
    }

    private String[] requestCarNamesInput() {
        String carNamesInput = InputView.requestCarNameInput();
        String[] carNames = splitByComma(carNamesInput);
        validateNoDuplicates(carNames);

        return carNames;
    }

    private int requestTotalRoundsInput() {
        String totalRoundsInput = InputView.requestTotalRoundsInput();
        int totalRoundsNum = toInt(totalRoundsInput);
        validatePositiveInt(totalRoundsNum);

        return totalRoundsNum;
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
