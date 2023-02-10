package car;

import car.controller.GameController;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
        gameController.play();
        gameController.showResult();
    }
}
