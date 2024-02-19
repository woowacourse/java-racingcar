package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int START_POSITION = 0;

    private final String name;
    private int position;

    public Car(final String name) {
        validate(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private void validate(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 빈칸이 아니어야 합니다. : " + name);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하이어야 합니다. : " + name);
        }
    }

    public void move(final boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    public boolean isPositionedAt(final int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
