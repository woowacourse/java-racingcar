package domain.accelerator.strategy;

import domain.accelerator.Accelerator;

public class MoveAccelerator implements Accelerator {

    public int push() {
        return MIN_MOVABLE_POWER;
    }
}
