package racingcar;

import racingcar.common.log.ConsoleLogger;
import racingcar.common.log.Logger;
import racingcar.controller.RacingCarController;
import racingcar.domain.NumberGenerator;
import racingcar.step.CreateCarStep;
import racingcar.step.Step;

public class RacingCarApplication {

    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        RacingCarController racingCarController = new RacingCarController(generator);
        Logger log = new ConsoleLogger();

        Step step = new CreateCarStep(racingCarController, log);
        run(step);
    }

    private static void run(Step step) {
        while (step.executable()) {
            step = step.execute();
        }
    }
}
