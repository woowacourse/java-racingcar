package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.ParseUtils.toInt;
import static racingcar.util.SplitUtils.splitByComma;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;
import static racingcar.util.ValidatorUtils.validatePositiveInt;

public class GameController {

    private Game game;

    public void run() {
        initGame();
        playGame();
        printGameResult();
    }

    private void initGame() {
        String[] carNames = requestCarNamesInput();
        int totalRounds = requestTotalRoundsInput();

        game = new Game(carNames, totalRounds);
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

        while (!game.isOver()) {
            game.playRound();
            OutputView.printRoundResult(game.getCars());
        }
    }

    private void printGameResult() {
        List<Car> winners = game.getWinners();
        OutputView.printWinners(winners);
    }
}
