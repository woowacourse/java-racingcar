package racingcar;

import racingcar.controller.GameController;

public class GameApplication {

    private final AppConfig appConfig = AppConfig.getInstance();

    public static void main(String[] args) {
        GameApplication gameApplication = new GameApplication();
        gameApplication.run();
    }

    public void run() {
        GameController gameController = appConfig.gameController;
        gameController.initGame();
        gameController.playGame();
    }

}
