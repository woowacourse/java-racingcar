package racingcar.domain;

public class CarAccelerator implements Accelerator {
    public static final int MIN_ACCEL_POWER = 0;
    public static final int MAX_ACCEL_POWER = 9;

    @Override
    public int push() {
        return RandomNumberGenerator.generate(MIN_ACCEL_POWER, MAX_ACCEL_POWER);
    }
}
