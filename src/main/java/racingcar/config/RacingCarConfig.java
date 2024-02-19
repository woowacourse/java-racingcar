package racingcar.config;

import racingcar.domain.generator.OilGenerator;
import racingcar.domain.generator.RandomOilGenerator;

public class RacingCarConfig {

    private static final OilGenerator oilGenerator = new RandomOilGenerator();

    public static OilGenerator oilGenerator() {
        return oilGenerator;
    }
}
