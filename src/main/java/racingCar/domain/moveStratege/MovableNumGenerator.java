package racingCar.domain.moveStratege;

public class MovableNumGenerator implements NumGenerator {
    public static final int MOVABLE_NUM = 4;

    @Override
    public int generate() {
        return MOVABLE_NUM;
    }
}
