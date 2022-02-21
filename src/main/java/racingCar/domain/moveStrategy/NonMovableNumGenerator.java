package racingCar.domain.moveStrategy;

public class NonMovableNumGenerator implements NumGenerator {
    private static final int NON_MOVABLE_NUM = 3;

    @Override
    public int generate() {
        return NON_MOVABLE_NUM;
    }
}
