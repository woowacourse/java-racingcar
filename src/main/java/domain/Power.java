package domain;

import jdk.jfr.Threshold;

public class Power {

    private static final Integer THRESHOLD = 4;

    private final Integer power;

    private Power(int power) {
        this.power = power;
    }

    public static Power from(int power) {
        return new Power(power);
    }

    public boolean isSufficientPower() {
        return THRESHOLD <= this.power;
    }
}
