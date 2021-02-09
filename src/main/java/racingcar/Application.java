package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController racingGame = new RacingGameController(new OutputView(), new InputView());
        racingGame.start();
    }
}
