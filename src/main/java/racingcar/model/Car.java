package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int MINIMUM_POSITION = 0;
    private static final int MOVE_FORWARD = 4;

    private final Name name;
    private int position;

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(Name name) {
        this(name, MINIMUM_POSITION);
    }

    public void move(NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        if (canMove(number)) {
            position++;
        }
    }

    private boolean canMove(int number) {
        return number >= MOVE_FORWARD;
    }


    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
