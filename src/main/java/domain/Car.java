package domain;

import domain.accelerator.Accelerator;

public class Car {
    private final CarName name;
    private int position;
    private final Accelerator accelerator;

    public Car(String name, Accelerator accelerator) {
        this.name = new CarName(name);
        this.position = 0;
        this.accelerator = accelerator;
    }

    public void pushAccelerator() {
        moveForward(accelerator.push());
    }

    private void moveForward(int power) {
        if (power >= Accelerator.MIN_MOVABLE_POWER) {
            position++;
        }
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }
}
