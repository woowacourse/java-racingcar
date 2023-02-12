package racingcar.domain;

public class DefaultNumberGenerator implements NumberGenerator {
    private final int num;

    public DefaultNumberGenerator(int num) {
        this.num = num;
    }

    @Override
    public int getNumber() {
        return num;
    }
}
