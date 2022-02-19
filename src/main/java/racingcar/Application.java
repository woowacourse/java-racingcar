package racingcar;

import racingcar.controller.GameController;
import racingcar.domain.RandomMoveStrategy;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run(new RandomMoveStrategy());
    }
}
