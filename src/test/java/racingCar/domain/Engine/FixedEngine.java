package racingCar.domain.Engine;

public class FixedEngine implements Engine {

    private final int num;

    public FixedEngine(int num) {
        this.num = num;
    }

    @Override
    public boolean isMove() {
        return num > MOVE_CRITERIA;
    }
}
