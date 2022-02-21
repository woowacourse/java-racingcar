package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        racingController.start(moveStrategy);
    }
}
