package racingcar.domain;

import racingcar.validator.CarValidator;

import java.util.Objects;

public class Car {
    private static final int MIN_VALUE_TO_MOVE = 4;

    private final String name;
    private int position;

    private Car(String name) {
        CarValidator.validateCarNameIsNullOrEmpty(name);
        String trimmedName = name.trim();
        CarValidator.validateCarNameLength(trimmedName);
        this.name = trimmedName;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public void tryToMove(int number) {
        if (number >= MIN_VALUE_TO_MOVE) {
            this.position++;
        }
    }

    //TODO 메서드명을 MaxPosition과 Position이 같다는걸 증명한다는 늬앙스로 변경하기
    public boolean isMaxPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(this.name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
