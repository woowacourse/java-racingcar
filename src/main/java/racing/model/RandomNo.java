package racing.model;

import java.util.Random;

public class RandomNo {
    private int randomNo;

    public RandomNo(){
        randomNo = new Random().nextInt(9) + 1;
    }

    public boolean isMovable() {
        return randomNo >= 4;
    }
}
