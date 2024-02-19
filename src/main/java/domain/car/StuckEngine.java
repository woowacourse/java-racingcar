package domain.car;

public class StuckEngine implements MovableStrategy {
    private final int power = 3;

    @Override
    public boolean isMove() {
        return false;
    }
}
