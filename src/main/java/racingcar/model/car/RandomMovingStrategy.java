package racingcar.model.car;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    @Override
    public boolean movable() {
        Random ran = new Random();
        int x = ran.nextInt(10);

        return x >= 4;
    }
}
