package racingcar;

import racingcar.controller.GameManager;

public class RacingcarApplication {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.run();
    }
}
