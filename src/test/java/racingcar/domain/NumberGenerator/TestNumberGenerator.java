package racingcar.domain.NumberGenerator;

import racingcar.domain.NumberGenerator.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {
    private final int num;

    public TestNumberGenerator(int num) {
        this.num = num;
    }

    @Override
    public int getNumber() {
        return num;
    }
}
