package racing;

import racing.controller.GameController;

public class RacingGameApplication {
    public static void main(String[] args) {
        GameController game = new GameController();
        game.start();
    }
}
