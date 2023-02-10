package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.controller.Retry;
import racingcar.domain.game.MathNumberGenerator;
import racingcar.domain.game.NumberGenerator;
import racingcar.domain.game.WinnerJudge;

public class RacingCarApplication {

    public static void main(String[] args) {
        NumberGenerator generator = new MathNumberGenerator();
        WinnerJudge winnerJudge = new WinnerJudge();

        RacingCarController racingCarController = new RacingCarController(generator, winnerJudge);
        Retry retry = new Retry(2);

        racingCarController.gameStart(retry);
    }
}

