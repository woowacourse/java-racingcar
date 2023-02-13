package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.game.MathRandom;
import racingcar.domain.game.NumberGenerator;
import racingcar.domain.game.RandomNumberGenerator;

public class RacingCarApplication {

    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        RacingCarController racingCarController = new RacingCarController(generator);
        racingCarController.gameStart();
    }
}
