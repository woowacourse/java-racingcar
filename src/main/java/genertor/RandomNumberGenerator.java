package genertor;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int MAX_MOVING_NUM = 9;

    @Override
    public int getNum() {
        Random random = new Random();
        return random.nextInt(MAX_MOVING_NUM);
    }
}
