package racingcar;

import static racingcar.util.ValidatorUtils.validateAndParseBoolean;

import racingcar.controller.GameController;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    private static final GameController gameController = new GameController();

    public static void main(String[] args) {
        do {
            String carNamesInput = InputView.requestCarNameInput();
            String totalRoundsInput = InputView.requestTotalRoundsInput();
            Game game = Game.byUserInput(carNamesInput, totalRoundsInput);

            OutputView.printGameResult(gameController.playAndGetRoundResults(game));
            OutputView.printWinners(game.getWinners());

            gameController.clearGameData(game);
        } while (validateAndParseBoolean(InputView.requestRestartGameInput()));
    }
}
