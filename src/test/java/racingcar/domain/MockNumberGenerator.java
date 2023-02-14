package racingcar.domain;

public class MockNumberGenerator implements NumberGenerator {

    private final int number;

    MockNumberGenerator(int number) {
        this.number = number;
    }

    @Override
    public int generate() {
        return number;
    }
}
