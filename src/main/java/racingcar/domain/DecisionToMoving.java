package racingcar.domain;

public class DecisionToMoving implements Movable {
    private static final int MOVE_FLAG = 3;

    @Override
    public boolean isMoving() {
        return (int)(Math.random() * 100) % 10 > MOVE_FLAG;
    }
}
