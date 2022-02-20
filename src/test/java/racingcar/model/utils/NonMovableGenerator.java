package racingcar.model.utils;

import racingcar.model.utils.NumberGenerator;

public class NonMovableGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return 3;
    }
}
