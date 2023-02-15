package racingcar.domain;

public class TestNumberGenerator implements NumberGenerator {
    private int MOVE = 6;

    @Override
    public int generate() {
        return MOVE;
    }

}
