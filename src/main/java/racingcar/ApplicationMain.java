package racingcar;

import racingcar.controller.GameController;

public class ApplicationMain {

    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.runGame();
            gameController.finishGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
