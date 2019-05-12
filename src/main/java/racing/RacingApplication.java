package racing;

import racing.controller.RacingGame;

public class RacingApplication {

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.setupGame();
        racingGame.startGame();
        racingGame.endGame();
    }
}
