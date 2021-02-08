package racing.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Car {
    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{1,5}");
    private static final int MINIMUM_MOVE_NUMBER = 4;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        String copy = new String(name);
        validateName(copy);
        this.name = copy;
        this.position = DEFAULT_POSITION;
    }

    private void validateName(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
        Matcher matcher = PATTERN.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("%s는 유효하지 않은 이름입니다. 영어 대소문자만 입력해주세요.", name));
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

