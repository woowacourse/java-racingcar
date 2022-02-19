package racingcar;

import racingcar.controller.RacingGame;
import racingcar.numberGenerator.NumberGenerator;
import racingcar.numberGenerator.RandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        racingGame.play(randomNumberGenerator);
    }
}
