package racing.model;

import java.util.Random;

public class RandomNo {
    public static final int UPPER_BOUND = 9;
    public static final int LOWER_BOUND = 1;
    public static final int CRITERIA_NUMBER = 4;
    private int randomNo;

    public RandomNo(){
        randomNo = new Random().nextInt(UPPER_BOUND) + LOWER_BOUND;
    }

    public boolean isMovable() {
        return randomNo >= CRITERIA_NUMBER;
    }
}
