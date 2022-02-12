package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int STANDARD = 4;

    private String name;
    private int position;
    private NumberGenerator numberGenerator;

    public Car(String name, int position, NumberGenerator numberGenerator) {
        this.name = name;
        this.position = position;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (numberGenerator.generate() >= STANDARD) {
            position++;
        }
    }
}
