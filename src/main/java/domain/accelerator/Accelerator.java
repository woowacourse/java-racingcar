package domain.accelerator;

public interface Accelerator {
    int MIN_ACCEL_POWER = 0;
    int MAX_ACCEL_POWER = 9;
    int MIN_MOVABLE_POWER = 4;

    int push();
}
