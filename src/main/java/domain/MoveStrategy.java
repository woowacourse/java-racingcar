package domain;

@FunctionalInterface
public interface MoveStrategy {
    boolean canMove();
}
