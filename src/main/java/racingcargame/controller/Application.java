package racingcargame.controller;

public class Application {

    public static void main(String[] args) {
        GameController gameController = GameController.getGameController();
        gameController.runGame();
    }
}
