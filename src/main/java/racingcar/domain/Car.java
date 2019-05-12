package racingcar.domain;

import java.util.Collections;
import java.util.Objects;

public class Car implements Cloneable, Comparable {
    private static final String BLANK_REGEX = "\\s*";
    private static final int MIN_NUM_TO_ACCELERATE = 4;
    private static final int MAX_NUM_OF_CAR_NAME = 5;
    private static final int MIN_NUM_OF_POSITION = 0;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, final int position) {
        validateName(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    private void validateName(final String name) {
        checkNull(name);
        checkLengthOfName(name);
        checkBlank(name);
    }

    private void checkNull(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null Error");
        }
    }

    private void checkLengthOfName(final String name) {
        if (name.length() > MAX_NUM_OF_CAR_NAME) {
            throw new IllegalArgumentException(MAX_NUM_OF_CAR_NAME + "자 이하의 자동차 이름을 입력하세요");
        }
    }

    private void checkBlank(final String name) {
        if (name.matches(BLANK_REGEX)) {
            throw new IllegalArgumentException("자동차 이름을 공백으로 입력하지마세요");
        }
    }

    private void validatePosition(final int position) {
        if (position < MIN_NUM_OF_POSITION) {
            throw new IllegalArgumentException("자동차의 위치는 0 이상을 입력하세요.");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void accelerate() {
        accelerate(RandomGenerator.generateRandomNum());
    }

    public void accelerate(int numToAccelerate) {
        if (numToAccelerate >= MIN_NUM_TO_ACCELERATE) {
            position++;
        }
    }

    public boolean isEqualCar(Car other) {
        return matchPosition(other.position);
    }

    public boolean matchPosition(int position) {
        return (this.position == position);
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
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return (position == car.position) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
