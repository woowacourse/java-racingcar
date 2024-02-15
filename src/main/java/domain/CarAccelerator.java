package domain;

import util.RandomNumberUtils;

public class CarAccelerator {
    public static final int MIN_ACCEL_POWER = 0;
    public static final int MAX_ACCEL_POWER = 9;

    public int push() {
        return RandomNumberUtils.generate(MIN_ACCEL_POWER, MAX_ACCEL_POWER);
    }
}
