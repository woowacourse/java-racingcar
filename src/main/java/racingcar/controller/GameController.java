package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import static racingcar.util.ValidatorUtils.splitAndValidateCarNames;
import static racingcar.util.ValidatorUtils.validateAndParsePositiveInt;

public class GameController {

    public void run() {
        String[] carNames = requestCarNamesInput();
        int totalRounds = requestTotalRoundsInput();

        Game game = new Game(carNames, totalRounds);
        game.playAllRounds();
        OutputView.printWinners(game.getWinners());
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
