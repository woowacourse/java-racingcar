package domain.car;

public interface MovableStrategy {
    int FORWARD_THRESHOLD = 4;

    boolean isMove();
}
