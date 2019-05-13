package racingcar.domain;

import racingcar.validator.InputValidator;

import java.util.Collections;
import java.util.Objects;

public class Car implements Cloneable, Comparable {
    private static final int MIN_NUM_TO_ACCELERATE = 4;
    public static final int MAX_NUM_OF_CAR_NAME = 5;
    private final String name;
    private int position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position) {
        InputValidator.checkNull(name);
        InputValidator.checkBlank(name);
        checkLengthOfName(name);
        this.name = name;
        this.position = position;
    }

    private void checkLengthOfName(String name) {
        if (name.length() > MAX_NUM_OF_CAR_NAME) {
            throw new IllegalArgumentException(MAX_NUM_OF_CAR_NAME + "자 이하의 자동차 이름을 입력해 주세요.");
        }
    }

    public boolean accelerate(int numToAccelerate) {
        if (numToAccelerate >= MIN_NUM_TO_ACCELERATE) {
            position++;
            return true;
        }
        return false;
    }

    public boolean isEqualPosition(Car car) {
        return (car.isEqualPosition(this.position));
    }

    public boolean isEqualPosition(int position) {
        return (this.position == position);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public String toString() {
        return (getAlignedName() + " : " + getPositionLines());
    }

    private String getAlignedName() {
        return String.format("%-" + MAX_NUM_OF_CAR_NAME + "s", this.name);
    }

    private String getPositionLines() {
        return String.join("", Collections.nCopies(this.position, "-"));
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        return (Car) super.clone();
    }

    @Override
    public int compareTo(Object o) {
        Car car = (Car) o;
        Integer positionToCompare = car.getPosition();
        return Integer.valueOf(this.position).compareTo(positionToCompare);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
