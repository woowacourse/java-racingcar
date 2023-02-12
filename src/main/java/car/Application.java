package car;

import car.controller.GameController;
import car.view.InputConsole;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputConsole());
        gameController.startGame();
        gameController.play();
        gameController.showResult();
    }
}
