package racingCar.domain.Engine2;

public class Engine2 {

    protected static int MOVE_CRITERIA = 3;
    protected static final int MIN_VALUE = 0;
    protected static final int MAX_VALUE = 9;
    private final int num;

    public Engine2(int num){
        this.num = num;
    }

    public boolean isMove(){
        return num > MOVE_CRITERIA;
    }

}
