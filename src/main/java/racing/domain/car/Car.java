package racing.domain.car;

import racing.domain.RandomNumberPicker;
import racing.domain.race.NumberPicker;

public class Car {
    private static final int LEAST_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int DEFAULT_START_POSITION = 0;
    private static final int ONE_STEP = 1;
    private final String name;
    private int position = DEFAULT_START_POSITION;

    private final NumberPicker numberPicker;

    public Car(String name) {
        numberPicker = new RandomNumberPicker();
        validate(name);
        this.name = name;
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public Car(String name, NumberPicker numberPicker) {
        this.name = name;
        this.numberPicker = numberPicker;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 다섯 글자 이하여야합니다.");
        }
    }

    public void moveDependingOn() {
        int pickedNumber = numberPicker.pickNumber();
        if (pickedNumber >= LEAST_CONDITION) {
            position += ONE_STEP;
        }
    }
}
