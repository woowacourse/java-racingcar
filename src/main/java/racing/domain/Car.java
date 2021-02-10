package racing.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");
    private static final String INVALID_NAME_FORMAT = "자동차 이름은 5자 이하의 알파벳으로 구성되어야 합니다.";
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private final MovingStrategy movingStrategy;
    private int position = DEFAULT_POSITION;

    public Car(String name, MovingStrategy movingStrategy) {
        validateName(name);
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    private void validateName(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT);
        }
        Matcher matcher = PATTERN.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_NAME_FORMAT);
        }
    }

    public void move() {
        if (movingStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

