package racingcargame.domain;

public class LimitEngine implements Engine {
    private static final int LIMIT = 4;

    @Override
    public boolean isMovable(int power) {
        return LIMIT <= power;
    }
}
