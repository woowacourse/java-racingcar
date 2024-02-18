package domain;

import utils.NumberGenerator;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private int location;

    public Car(String name) {
        this.name = new CarName(name);
        location = 0;
    }

    public void tryMove(int number) {
        if (number >= MOVE_THRESHOLD) {
            location += 1;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name.getName();
    }
}
