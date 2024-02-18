package domain.power;

public record Power(int power) {
    private static final int FORWARD_POWER = 4;

    public boolean isEnoughPower() {
        return power >= FORWARD_POWER;
    }
}
