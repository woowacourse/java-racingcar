package strategy;


import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {

    private final int MAX_MOVING_NUM = 9;

    @Override
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_MOVING_NUM);
    }
}
