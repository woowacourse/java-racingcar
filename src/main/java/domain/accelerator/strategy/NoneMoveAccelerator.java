package domain.accelerator.strategy;

import domain.accelerator.Accelerator;

public class NoneMoveAccelerator implements Accelerator {

    public int push() {
        return MIN_MOVABLE_POWER - 1;
    }
}
