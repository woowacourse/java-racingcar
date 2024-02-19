package domain.car;

public class MovableEngine implements MovableStrategy {
    private final int power = 4;

    @Override
    public boolean isMove() {
        return true;
    }
}
