package strategy;

import static utils.Constant.MAX_MOVING_NUM;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    @Override
    public int getNum() {
        Random random = new Random();
        int randomNum = random.nextInt(MAX_MOVING_NUM);
        return randomNum;
    }
}
