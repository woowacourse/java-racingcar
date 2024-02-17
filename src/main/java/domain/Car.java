package domain;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 빈칸이 아니어야 합니다. : " + name);
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하이어야 합니다. : " + name);
        }
    }

    public void move(boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
