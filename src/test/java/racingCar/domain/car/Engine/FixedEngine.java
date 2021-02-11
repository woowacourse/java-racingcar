package racingCar.domain.car.Engine;

public class FixedEngine implements Engine {

    private final int num;
    private final int criteria;

    public FixedEngine(int num) {
        this(num, 3);
    }

    public FixedEngine(int num, int criteria) {
        this.num = num;
        this.criteria = criteria;
    }

    @Override
    public boolean movable() {
        return num > criteria;
    }
}
