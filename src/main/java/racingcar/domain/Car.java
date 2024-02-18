package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int progress;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.progress = 0;
    }

    public void move() {
        this.progress++;
    }

    private void validate(String name) {
        if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "자동차의 이름은 %d~%d글자 사이입니다.".formatted(MIN_NAME_LENGTH, MAX_NAME_LENGTH)
            );
        }
    }

    public String getName() {
        return name;
    }

    public Integer getProgress() {
        return progress;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Car car
                && this.name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

