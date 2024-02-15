package domain;

public class Car {
    private String name;

    private int position;
    private final CarAccelerator accelerator;

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
        if (power >= 4) {
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
