package javaracingcar.domain;

public class Car {
    private static final int CAR_NAME_LENGTH_MAX_SIZE = 4;
    private static final int CAR_MOVES = 4;

    private final String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static Car generateCar(String name) {
        validateName(name);
        return new Car(name);
    }

    private static void validateName(String name) {
        validateNull(name);
        validateEmptyString(name);
        validateNameLength(name);
    }

    private static void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null 이 입력되었습니다.");
        }
    }

    private static void validateEmptyString(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() > CAR_NAME_LENGTH_MAX_SIZE) {
            throw new IllegalArgumentException("이름이 최대길이를 초과했습니다.");
        }
    }

    public void move(int value) {
        if (value >= CAR_MOVES) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
