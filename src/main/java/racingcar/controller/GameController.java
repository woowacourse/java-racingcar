package racingcar.controller;

import racingcar.domain.Game;
import racingcar.view.OutputView;

public class GameController {

    public void playGameUntilEnd(Game game) {
        OutputView.printRoundResultText();

        while (!game.isOver()) {
            game.playRound();
            OutputView.printRoundResult(game.getCars());
        }
    }

    public void clearGameData(Game game) {
        game.clearCars();
    }
}
