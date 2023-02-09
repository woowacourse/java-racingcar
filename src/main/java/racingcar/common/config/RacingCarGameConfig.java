package racingcar.common.config;

import racingcar.common.log.ConsoleLogger;
import racingcar.common.log.Logger;
import racingcar.domain.MathNumberGenerator;
import racingcar.domain.NumberGenerator;

public class RacingCarGameConfig {

    public NumberGenerator numberGenerator() {
        return new MathNumberGenerator();
    }

    public Logger logger() {
        return new ConsoleLogger();
    }
}
