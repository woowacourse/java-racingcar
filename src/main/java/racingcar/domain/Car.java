package racingcar.domain;

import racingcar.util.Validator;

public class Car {

    private final String name;
    private int position;
    private int turnCount;

    public Car(String name) {
        Validator.validateCarName(name);
        this.name = name;
        this.position = 0;
        this.turnCount = 0;
    }

    public void moveWith(int power, RacingRule rule) {
        turnCount++;
        if (rule.isMovable(power)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public String getName() {
        return name;
    }
}
