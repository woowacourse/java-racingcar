package racingcar;

import racingcar.common.config.RacingCarGameConfig;
import racingcar.controller.RacingCarController;
import racingcar.domain.game.WinnerJudge;
import racingcar.step.CreateCarStep;
import racingcar.step.Step;
import racingcar.step.context.GameContext;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingCarGameConfig config = new RacingCarGameConfig();
        RacingCarController racingCarController = new RacingCarController(config.numberGenerator(), new WinnerJudge());
        Step step = new CreateCarStep(racingCarController, config.logger(), GameContext.init());
        run(step);
    }

    private static void run(Step step) {
        while (step.executable()) {
            step = step.execute();
        }
    }
}
