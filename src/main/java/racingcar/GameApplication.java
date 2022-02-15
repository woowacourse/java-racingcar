package racingcar;

import racingcar.controller.GameController;

public class GameApplication {

    private final GameController gameController;

    public GameApplication(AppConfig appConfig) {
        this.gameController = appConfig.gameController;
    }

    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();
        GameApplication gameApplication = new GameApplication(appConfig);
        gameApplication.run();
    }

    public void run() {
        gameController.initGame();
        gameController.playGame();
    }

}
