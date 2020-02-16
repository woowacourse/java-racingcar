package racing.model;

import java.util.Random;

public class RandomNo {
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;
    private static final int CRITERIA_NUMBER = 4;
    private int randomNo;

    public RandomNo(){
        randomNo = new Random().nextInt(UPPER_BOUND) + LOWER_BOUND;
    }

    public boolean isMovable() {
        return randomNo >= CRITERIA_NUMBER;
    }
}
