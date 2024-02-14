package racingcar.domain;

import racingcar.service.RandomNumberGenerator;

public class Car {
    private static final String CAR_POSITION_SYMBOL = "-";

    private final String name;
    private int position = 0;

    public Car(final String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(final String name) {
        validateNotNull(name);
        validateNameStyle(name);
        validateNameSize(name);
    }

    private void validateNotNull(final String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름에 공백을 입력할 수 없습니다.");
        }
    }

    private void validateNameStyle(final String name) {
        final String regex = "^[a-zA-Z0-9_-]";
        if (!name.matches(regex)) {
            throw new IllegalArgumentException("올바르지 않은 자동차 이름입니다.");
        }
    }

    private void validateNameSize(final String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과합니다");
        }
    }

    public void move(final int threshold) {
        if (threshold >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String result() {
        return name + " : " + CAR_POSITION_SYMBOL.repeat(position);
    }
}
