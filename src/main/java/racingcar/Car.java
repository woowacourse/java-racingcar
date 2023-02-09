package racingcar;

import racingcar.util.Validator;

public class Car {

    public static final int MOVE_RANGE = 1;
    private static final int INIT_POSITION = 0;
    private static final int BOUNDARY = 4;

    private final String name;
    private int position;

    public Car(String name) {
        Validator.validateCarNames(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    public void move(int number) {
        if (number >= BOUNDARY) {
            this.position += MOVE_RANGE;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
