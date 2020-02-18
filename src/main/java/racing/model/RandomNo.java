package racing.model;

import java.util.Random;

public class RandomNo {
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;
    private static final Random random = new Random();

    private int randomNo;

    public RandomNo(){
        randomNo = random.nextInt(UPPER_BOUND) + LOWER_BOUND;
    }

    public int getNumber() {
        return randomNo;
    }
}
