package racingcargame;

import racingcargame.controller.GameController;
import racingcargame.utils.MoveGenerator;
import racingcargame.utils.NumberGenerator;
import racingcargame.utils.RandomNumberGenerator;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView(),
                new MoveGenerator(new RandomNumberGenerator()));
        gameController.runGame();
    }
}
