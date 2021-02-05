package racingcar.domain;

import java.util.regex.Pattern;

public class Car {
    private static final String REGEX_ALPHA = "^[a-zA-z]*$";
    private static final String REGEX_KOREAN = "[가-힣]*$";
    private static final int NAME_LENGTH_LIMIT = 5;

    private String name;
    private int position;

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    public void carMove() {
        this.position++;
    }

    public int getPosition(){
        return this.position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    private void validateName(final String name) {
        if (isNullName(name) || isContainInvalidChar(name) || isExceedNameLength(name)) {
            throw new IllegalArgumentException("잘못된 자동차 이름입니다.");
        }
    }

    private boolean isNullName(final String name) {
        return "".equals(name);
    }

    private boolean isContainInvalidChar(final String name) {
        return !Pattern.matches(REGEX_ALPHA, name) && !Pattern.matches(REGEX_KOREAN, name);
    }

    private boolean isExceedNameLength(final String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }
}
