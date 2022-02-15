package racingcar.model;

import racingcar.util.NumberGenerator;

public class Car {
    private static final int MINIMUM_POSITION = 0;
    private static final int MOVE_FORWARD = 4;

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
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


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
