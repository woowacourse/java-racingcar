package strategy;

import static utils.Constant.MAX_MOVING_NUM;

import domain.Car;
import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    @Override
    public void isAllowedToMove(Car car) {
        car.move(getRandomNum());
    }

    private int getRandomNum() {
        Random random = new Random();
        int randomNum = random.nextInt(MAX_MOVING_NUM);
        return randomNum;
    }
}
