package racingCar.domain.moveStrategy;

public class MovableNumGenerator implements NumGenerator {
    private static final int MOVABLE_NUM = 4;

    @Override
    public int generate() {
        return MOVABLE_NUM;
    }
}
