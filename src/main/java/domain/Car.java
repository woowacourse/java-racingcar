package domain;

import utils.NumberGenerator;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private int location;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = new CarName(name);
        this.numberGenerator = numberGenerator;
        location = 0;
    }

    public void tryMove() {
        int number = numberGenerator.generate();
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
