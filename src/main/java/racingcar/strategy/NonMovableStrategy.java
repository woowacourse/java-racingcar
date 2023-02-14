package racingcar.strategy;

public class NonMovableStrategy implements MovingStrategy {

    @Override
    public int move() {
        return 3;
    }
}
