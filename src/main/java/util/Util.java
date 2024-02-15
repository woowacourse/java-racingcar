package util;

import java.util.Random;

public class Util {
    
    private static final int BOUND = 10;

    public static int generateRandomNumber() {
        return new Random().nextInt(BOUND);
    }
}
