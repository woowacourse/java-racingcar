package utils;

public class ImmovableEngine implements Engine {
    private static final int POWER = 0;

    @Override
    public int generatePower() {
        return POWER;
    }
}
