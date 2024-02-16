package model;

import static view.OutputView.ERROR_PREFIX;

public class Car {

    private static final int INITIAL_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_MIN_NUMBER = 4;
    private static final String NAME_DELIMITER = " : ";
    private static final String TRACE_SYMBOL = "-";
    private final String name;
    private int position;

    private Car(String name) {
        this.position = INITIAL_POSITION;
        this.name = name;
    }

    public static Car from(String name) {
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

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String showTrace(String nameDelimiter, String traceSymbol) {
        StringBuilder trace = new StringBuilder();
        trace.append(name).append(NAME_DELIMITER);
        for (int i = 0; i < position; i++) {
            trace.append(TRACE_SYMBOL);
        }
        return trace.toString();
    }
}
