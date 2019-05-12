package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        try {
            RacingGameController racingGameController = new RacingGameController();
            racingGameController.playRacingGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
