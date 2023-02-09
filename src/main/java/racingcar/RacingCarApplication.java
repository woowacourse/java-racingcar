package racingcar;

import racingcar.common.log.ConsoleLogger;
import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.domain.NumberGenerator;
import racingcar.step.CreateCarStep;
import racingcar.step.Step;
import racingcar.step.context.GameContext;

public class RacingCarApplication {

    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        RacingCarController racingCarController = new RacingCarController(generator);
        Logger log = new ConsoleLogger();

        GameContext context = new GameContext();
        Step step = new CreateCarStep(racingCarController, log, context);
        run(step);
    }

    private static void run(Step step) {
        while (step.executable()) {
            step = step.execute();
        }
    }
}
