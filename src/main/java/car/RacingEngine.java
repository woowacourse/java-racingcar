package car;

import java.util.Random;

public class RacingEngine implements Engine {
    
    private static final int RANDOM_UPPER_BOUND = 10;
    
    private final Random random;
    
    public RacingEngine() {
        this.random = new Random();
    }
    
    @Override
    public boolean isEnoughFuel() {
        return random.nextInt(RANDOM_UPPER_BOUND) >= MOVE_CONDITION;
    }
}
