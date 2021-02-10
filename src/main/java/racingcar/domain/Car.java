package racingcar.domain;

import java.util.regex.Pattern;

public class Car implements Comparable<Car> {
    private static final Pattern PATTERN_ALPHA = Pattern.compile("^[a-zA-z]*$");
    private static final Pattern PATTERN_KOREAN = Pattern.compile("^[가-힣]*$");
    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MOVE_PIVOT = 4;

    private String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        validateName(name);
        this.name = name;
        this.position = position;
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
        return !PATTERN_ALPHA.matcher(name).matches() && !PATTERN_KOREAN.matcher(name).matches();
    }

    private boolean isExceedNameLength(final String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }

    public void moveForward(int randomNumber) {
        if (isMoveNumber(randomNumber)) {
            this.position++;
        }
    }

    private boolean isMoveNumber(final int number) {
        return MOVE_PIVOT <= number;
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
