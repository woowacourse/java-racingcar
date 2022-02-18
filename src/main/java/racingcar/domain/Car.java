package racingcar.domain;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int STANDARD = 4;
    private static final int DEFAULT_POSITION = 0;

    private String name;
    private int position = DEFAULT_POSITION;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
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
