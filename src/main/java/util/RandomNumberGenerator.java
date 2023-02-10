package util;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int RANDOM_NUMBER_STANDARD = 10;
    private static final int CAR_MOVE_STANDARD_LENGTH = 4;

    @Override
    public boolean generateNumber() {
        Random random = new Random();
        if(random.nextInt(RANDOM_NUMBER_STANDARD)>=CAR_MOVE_STANDARD_LENGTH) {
            return true;
        }
        return false;
    }
}
