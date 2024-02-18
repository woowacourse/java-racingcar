package model.powergenerator;

import java.util.Random;

public class RandomPowerGenerator implements PowerGenerator {
    @Override
    public int determinePower(int maxPower) {
        Random random = new Random();
        return random.nextInt(maxPower + 1);
    }
}
