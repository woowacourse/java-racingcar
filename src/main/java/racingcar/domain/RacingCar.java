package racingcar.domain;

import java.util.Objects;

public class RacingCar {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position = DEFAULT_POSITION;

    public RacingCar(String name) {
        isBlank(name);
        checkNameLength(name);
        this.name = name;
    }

    private void isBlank(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없다.");
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public boolean comparePosition(int position) {
        return this.position == position;
    }
}
