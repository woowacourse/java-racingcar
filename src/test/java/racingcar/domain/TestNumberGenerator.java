package racingcar.domain;

public class TestNumberGenerator implements NumberGenerator {
    private int INIT_MOVE = 6;

    @Override
    public int generate() {
        return INIT_MOVE;
    }

}
