package racingcar;

import racingcar.controller.RacingGame;
import racingcar.domain.RacingCars;

public class Application {

    public static void main(String[] args) {
        RacingCars racingCars = new RacingCars();
        RacingGame racingGame = new RacingGame(racingCars);

        racingGame.playGame();
        racingGame.finish();
    }

}
