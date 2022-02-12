package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int STANDARD = 4;
    private String name;
    private int position;
    private NumberGenerator randomGenerator;

    public Car(String name, int position, NumberGenerator randomUtil) {
        this.name = name;
        this.position = position;
        this.randomGenerator = randomUtil;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (randomGenerator.generate() >= STANDARD) {
            position++;
        }
    }
}
