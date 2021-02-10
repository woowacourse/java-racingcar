package racingcar;

import racingcar.domain.RacingGame;

public class RacingMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();

        while (racingGame.isRunning()) {
            racingGame.run();
        }
    }
}
