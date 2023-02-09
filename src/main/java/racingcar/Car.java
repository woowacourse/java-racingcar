package racingcar;

import racingcar.util.Validator;

public class Car {

    public static final int MOVE_RANGE = 1;
    private static final int INIT_POSITION = 0;
    private static final int BOUNDARY = 4;

    private final String name;
    private int position;

    public Car(String name) {
        String carName = name.trim();
        Validator.validateCarNames(carName);
        this.name = carName;
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
