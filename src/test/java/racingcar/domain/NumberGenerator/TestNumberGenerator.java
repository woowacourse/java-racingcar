package racingcar.domain.NumberGenerator;

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
