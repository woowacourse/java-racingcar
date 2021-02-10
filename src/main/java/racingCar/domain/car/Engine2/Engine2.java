package racingCar.domain.car.Engine2;

public class Engine2 {

    protected static final int MIN_VALUE = 0;
    protected static final int MAX_VALUE = 9;
    protected static int MOVE_CRITERIA = 3;
    private final int num;

    public Engine2(int num) {
        this.num = num;
    }

    public boolean isMove() {
        return num > MOVE_CRITERIA;
    }

}
