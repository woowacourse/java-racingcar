package model.powergenerator;

import java.util.Random;

public class RandomPowerGenerator implements PowerGenerator {
    private static final int NUMBER_BOUND = 10;

    @Override
    public int generatePower() {
        Random random = new Random();
        return random.nextInt(NUMBER_BOUND);
    }
}
