package racingcargame;

import racingcargame.controller.RacingGame;

public class RacingGameLauncher {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        RacingGame game = new RacingGame();
        game.play();
    }
}
