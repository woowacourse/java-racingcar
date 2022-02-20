package racingcargame;

import racingcargame.controller.GameController;
import racingcargame.model.carmovevalue.MoveValueGeneratorByRandomNumber;
import racingcargame.model.carmovevalue.randomnumbergenerator.RandomNumberGenerator;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView(),
                new MoveValueGeneratorByRandomNumber(new RandomNumberGenerator()));
        gameController.runGame();
    }
}
