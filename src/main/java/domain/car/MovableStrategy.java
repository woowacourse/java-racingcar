package domain.car;
@FunctionalInterface
public interface MovableStrategy {
    int FORWARD_THRESHOLD = 4;

    boolean isMove();
}
