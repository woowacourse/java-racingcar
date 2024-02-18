package domain.accelerator.strategy;

import domain.accelerator.Accelerator;
import util.RandomNumberUtils;

public class RandomMoveAccelerator implements Accelerator {

    public int push() {
        return RandomNumberUtils.generate(MIN_ACCEL_POWER, MAX_ACCEL_POWER);
    }
}
