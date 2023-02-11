package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.game.NumberGenerator;

public class RacingCarApplication {

    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();

        RacingCarController racingCarController = new RacingCarController(generator);

        racingCarController.gameStart();
    }
}
