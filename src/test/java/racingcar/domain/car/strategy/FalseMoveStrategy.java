package racingcar.domain.car.strategy;

public class FalseMoveStrategy implements MoveStrategy {

    public static FalseMoveStrategy FALSE_MOVE_STRATEGY = new FalseMoveStrategy();

    private FalseMoveStrategy() {
    }

    public static FalseMoveStrategy getInstance() {
        return FALSE_MOVE_STRATEGY;
    }

    @Override
    public boolean isMovable() {
        return false;
    }

}
