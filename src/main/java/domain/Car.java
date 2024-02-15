package domain;

public class Car {
    private String name;

    private int position;
    private final CarAccelerator accelerator;

    private static final int MIN_MOVABLE_POWER = 4;

    public Car(String name, CarAccelerator accelerator) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.position = 0;
        this.accelerator = accelerator;
    }

    public int pushAccelerator() {
        return accelerator.push();
    }

    public void moveForward(int power) {
        if (power >= MIN_MOVABLE_POWER) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
