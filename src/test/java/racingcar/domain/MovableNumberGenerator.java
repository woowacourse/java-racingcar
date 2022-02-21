package racingcar.domain;

import racingcar.utils.NumberGenerator;

public class MovableNumberGenerator implements NumberGenerator {
    @Override
    public int generateNumber() {
        return 4;
    }
}
