package utils;

public class RandomPowerMaker implements RandomPowerGenerator {

    @Override
    public int generateRandomPower() {
        return (int) (Math.random() * 10);
    }
}
