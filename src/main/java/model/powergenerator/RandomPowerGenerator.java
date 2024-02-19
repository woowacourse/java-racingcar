package model.powergenerator;

public class RandomPowerGenerator implements PowerGenerator {
    private static final int NUMBER_BOUND = 10;

    @Override
    public int generatePower() {
        return (int) (Math.random() * 10);
    }
}
