package racingcargame;

import racingcargame.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = GameController.getGameController();
        gameController.playGame();
    }
}
