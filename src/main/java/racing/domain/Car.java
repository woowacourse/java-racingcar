package racing.domain;

import racing.domain.number.Position;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");
    private static final int MINIMUM_MOVE_NUMBER = 4;

    private final String name;
    private final Position position;

    public Car(final String name) {
        String copy = new String(name);
        validateName(copy);
        this.name = copy;
        this.position = Position.of();
    }

    private void validateName(final String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
        Matcher matcher = PATTERN.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("%s는 유효하지 않은 이름입니다. 영어 대소문자만 입력해주세요.", name));
        }
    }

    public boolean move(final int randomNumber) {
        if (randomNumber >= MINIMUM_MOVE_NUMBER) {
            position.add();
            return true;
        }
        return false;
    }

    public int getPositionValue() {
        return position.getValue();
    }

    public String getName() {
        return name;
    }
}

