package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.util.ValidatorUtils.splitAndValidateCarNames;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;

public class GameController {

    private Game game;

    public void run() {
        String[] carNames = requestCarNamesInput();
        int totalRounds = requestTotalRoundsInput();

        game = new Game(carNames, totalRounds);
        playAllRounds();

        OutputView.printWinners(game.getWinners());
    }

    public void playAllRounds() {
        OutputView.printRoundResultText();

        while(!game.isOver()) {
            game.playRound();
            OutputView.printRoundResult(game.getCars());
        }
    }

    private String[] requestCarNamesInput() {
        String carNamesInput = InputView.requestCarNameInput();
        return splitAndValidateCarNames(carNamesInput);
    }

    private int requestTotalRoundsInput() {
        String totalRoundsInput = InputView.requestTotalRoundsInput();
        return validateAndParsePositiveInt(totalRoundsInput);
    }
}
