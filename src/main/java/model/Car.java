package model;

import static view.OutputView.ERROR_PREFIX;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_MIN_NUMBER = 4;

    private final String name;
    private int position;

    private Car(final String name) {
        this.position = INITIAL_POSITION;
        this.name = name;
    }

    public static Car from(final String name) {
        validateNameLength(name);
        return new Car(name);
    }

    private static void validateNameLength(String name) {
        if (name == null || name.trim().isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalStateException(ERROR_PREFIX + "자동차 이름은 한 글자 이상 다섯 글자 이하여야 합니다.");
        }
    }

    public void moveForward(int power) {
        if (power >= FORWARD_MIN_NUMBER) {
            position++;
        }
    }

    public String showPositionTraceByFormat(String symbol) {
        return symbol.repeat(position).trim();
    }

    public String getName() {
        return name;
    }
}
