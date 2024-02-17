package domain;

public class Car {
    private final CarName name;
    private int position;
    private final CarAccelerator accelerator;

    private static final int MIN_MOVABLE_POWER = 4;

    public Car(String name, CarAccelerator accelerator) {
        this.name = new CarName(name);
        this.position = 0;
        this.accelerator = accelerator;
    }


    public void pushAccelerator() {
        moveForward(accelerator.push());
    }

    public void moveForward(int power) {
        if (power >= MIN_MOVABLE_POWER) {
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
