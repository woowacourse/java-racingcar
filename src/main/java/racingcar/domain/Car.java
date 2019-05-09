package racingcar.domain;

import java.util.Collections;

public class Car {
    private static final String BLANK_REGEX = "\\s*";
    private static final int RANDOM_NUM_SCOPE = 10;
    private static final int MIN_NUM_TO_ACCELERATE = 4;
    public static final int MAX_NUM_OF_CAR_NAME = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        checkLengthOfName(name);
        checkBlank(name);
        this.name = name;
    }

    private void checkLengthOfName(String name) {
        if (name.length() > MAX_NUM_OF_CAR_NAME) {
            throw new IllegalArgumentException(MAX_NUM_OF_CAR_NAME + "자 이하의 자동차 이름을 입력하세요");
        }
    }

    private void checkBlank(String name) {
        if (name.matches(BLANK_REGEX)) {
            throw new IllegalArgumentException("자동차 이름을 공백으로 입력하지마세요");
        }
    }

    public void accelerate() {
        accelerate(generateRandomNum());
    }

    public void accelerate(int numToAccelerate) {
        if (numToAccelerate >= MIN_NUM_TO_ACCELERATE) {
            position++;
        }
    }

    private int generateRandomNum() {
        return (int) (Math.random() * RANDOM_NUM_SCOPE);
    }

    public boolean isEqualPosition(int position) {
        return (this.position == position);
    }

    @Override
    public boolean equals(Object object) {
        Car car = (Car) object;
        return (this.name.equals(car.getName()));
    }

    @Override
    public String toString() {
        return (getAlignedName() + " : " + getPositionLines());
    }

    public String getName() {
        return this.name;
    }

    public String getAlignedName() {
        return String.format("%-" + MAX_NUM_OF_CAR_NAME + "s", this.name);
    }

    private String getPositionLines() {
        return String.join("", Collections.nCopies(this.position, "-"));
    }
}
