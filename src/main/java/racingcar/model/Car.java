package racingcar.model;

import racingcar.util.RandomUtil;

public class Car {
    private static final int STANDARD = 4;

    private String name;
    private int position;
    private RandomUtil randomGenerator;

    public Car(String name, int position, RandomUtil randomUtil) {
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
