package racingCar.domain.Engine2;

import racingCar.utils.RandomUtils;

public class RandomEngine2 extends Engine2 {

    public RandomEngine2(int num){
        super(num);
    }

    @Override
    public boolean isMove(){
        return RandomUtils.nextInt(MIN_VALUE,MAX_VALUE) > MOVE_CRITERIA;
    }

}
