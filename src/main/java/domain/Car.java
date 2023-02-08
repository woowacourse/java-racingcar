package domain;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int START_POSITION = 0;
    public static final int ONE_STEP = 1;
    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = START_POSITION;
    }

    private void validateName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 다섯 글자 이하여야합니다.");
        }
    }

    public void move() {
        position += ONE_STEP;
    }
}
