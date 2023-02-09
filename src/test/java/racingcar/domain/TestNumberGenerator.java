package racingcar.domain;

public class TestNumberGenerator implements NumberGenerator {

    private final int number;

    TestNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
