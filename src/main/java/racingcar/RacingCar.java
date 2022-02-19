package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.movestrategy.RandomMovingStrategy;

public class RacingCar {

    public static void main(String[] args) {
        RacingController racingController = new RacingController(new RandomMovingStrategy());
        racingController.play();
    }
}
