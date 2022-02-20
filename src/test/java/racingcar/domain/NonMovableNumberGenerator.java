package racingcar.domain;

import racingcar.utils.NumberGenerator;

public class NonMovableNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return 3;
    }
}
