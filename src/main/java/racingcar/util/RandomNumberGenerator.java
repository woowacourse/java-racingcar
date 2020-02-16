package racingcar.util;

import java.util.Random;


public class RandomNumberGenerator implements NumberGenerator {
    private static final int MAX = 9;
    
    @Override
    public int generateNumber() {
        return new Random().nextInt(MAX + 1);
    }
}
