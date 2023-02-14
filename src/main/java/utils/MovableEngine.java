package utils;

public class MovableEngine implements Engine {
    private static final int POWER = 9;

    @Override
    public int generatePower() {
        return POWER;
    }
}
