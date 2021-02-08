package racing.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");
    private static final String INVALID_NAME_FORMAT = "자동차 이름은 빈 문자열이 아닌 5자 이하의 영어로 구성되어야 합니다.";
    private static final int MINIMUM_MOVE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
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

    public boolean move(int randomNumber) {
        if (randomNumber >= MINIMUM_MOVE_NUMBER) {
            this.position++;
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

