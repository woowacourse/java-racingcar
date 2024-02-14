package domain;

public class Power {

    private final Integer power;

    private Power(int power) {
        this.power = power;
    }

    public static Power from(int power) {
        return new Power(power);
    }
}
