package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.SplitUtils.splitByComma;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;

public class GameController {

    private Game game;

    public void run() {
        initGame();
        playGameUntilEnd();
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
}
