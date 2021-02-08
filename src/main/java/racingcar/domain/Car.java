package racingcar.domain;

import racingcar.utils.RandomUtils;

import java.util.regex.Pattern;

public class Car implements Comparable<Car> {
    private static final String REGEX_ALPHA = "^[a-zA-z]*$";
    private static final String REGEX_KOREAN = "[가-힣]*$";
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVE_PIVOT = 4;

    private String name;
    private int position;

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    @Override
    public int compareTo(final Car anotherCar) {
        return Integer.compare(this.getPosition(), anotherCar.getPosition());
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

    public void moveForward() {
        if (isMoveNumber(RandomUtils.createRandomNumber())) {
            this.position++;
        }
    }

    private boolean isMoveNumber(final int randomNumber) {
        return MOVE_PIVOT <= randomNumber;
    }

    public boolean isMaxPosition(final Car maxPositionCar) {
        return this.position == maxPositionCar.getPosition();
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
