package racingcar.model;

import racingcar.util.RandomNumberGenerator;
import racingcar.util.RandomUtil;

public class Car {
    private static final int STANDARD = 4;

    private String name;
    private int position;


    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isMovable(RandomUtil randomNumberGenerator) {
        if (randomNumberGenerator.generate() >= STANDARD) {
            return true;
        }
        return false;
    }

    public void move() {
        if (isMovable(new RandomNumberGenerator())) {
            position++;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }
}
