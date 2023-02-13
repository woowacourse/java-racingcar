package racing.domain.car;

import racing.domain.RandomNumberPicker;
import racing.domain.race.NumberPicker;

public class Car {
    private static final int LEAST_CONDITION = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int ONE_STEP = 1;
    private final String name;
    private final Position position;
    private NumberPicker numberPicker = new RandomNumberPicker();


    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = new Position();
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public Car(String name, NumberPicker numberPicker) {
        this.name = name;
        this.position = new Position();
        this.numberPicker = numberPicker;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getValue();
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
            position.add(ONE_STEP);
        }
    }
}
