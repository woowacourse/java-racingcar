package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();

        try {
            String carNames = racingGameController.requestCarList();
            String[] validCarNames = racingGameController.makeValidCarNames(carNames);
            racingGameController.generateCarList(validCarNames);

            int tryCount = racingGameController.requestTryCount();
            racingGameController.makeValidTryCount(tryCount);

            racingGameController.startRacingGame();
            racingGameController.findWinners();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
