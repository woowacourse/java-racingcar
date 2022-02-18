package racingcar.domain.car.strategy;

public class TrueMoveStrategy implements MoveStrategy {

    public static TrueMoveStrategy TRUE_MOVE_STRATEGY = new TrueMoveStrategy();

    private TrueMoveStrategy() {
    }

    public static TrueMoveStrategy getInstance() {
        return TRUE_MOVE_STRATEGY;
    }

    @Override
    public boolean isMovable() {
        return true;
    }

}
