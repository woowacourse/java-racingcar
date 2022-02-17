package racingcar;

import static racingcar.util.ValidatorUtils.validateAndParseBoolean;

import racingcar.controller.GameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final GameController gameController = new GameController();

    public static void main(String[] args) {
        do {
            String carNamesInput = InputView.requestCarNameInput();
            String totalRoundsInput = InputView.requestTotalRoundsInput();

            gameController.initGame(carNamesInput, totalRoundsInput);
            OutputView.printGameResult(gameController.playAndGetRoundResults());
            OutputView.printWinners(gameController.getWinners());
            gameController.clearGameData();
        } while (validateAndParseBoolean(InputView.requestRestartGameInput()));
    }
}
