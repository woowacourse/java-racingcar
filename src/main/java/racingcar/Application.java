package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.RacingCarGame;
import racingcar.view.RacingCarGameProgressView;
import racingcar.view.RacingCarGameResultView;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController(new RacingCarGame(), new RacingCarGameProgressView(), new RacingCarGameResultView());

        while (racingCarGameController.isRacing()) {
            racingCarGameController.race();
            racingCarGameController.printRaceProgress();
        }
        racingCarGameController.printFinalResult();
    }
}