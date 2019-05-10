package racing.domain;

import racing.util.RandomNumberGenerator;

import java.util.Objects;

public class Car {
    private static final int GO_FORWRARD_CRITERIA_NUM = 4;
    private static final int GO_STEP = 1;
    private static final int MAX_RANDOM_NUM_UPPER_BOUND = 10;
    private String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public Car(final String name, final int position) {
        this.name = name;
        this.position = position;
    }



    public void tryGoForward() {
        int randomNum = RandomNumberGenerator.generate(MAX_RANDOM_NUM_UPPER_BOUND);
        if (isGo(randomNum)) position += GO_STEP;
    }

    private boolean isGo(final int number) {
        return number >= GO_FORWRARD_CRITERIA_NUM;
    }



    /*
     * 자동차 위치 비교 메소드
     */
    public boolean isSameRank(final Car another) {
        return another.isSamePosition(position);
    }

    public boolean isSamePosition(final int position) {
        return this.position == position;
    }

    public boolean isFartherThan(final Car another) {
        return !another.isBiggerPosition(position);
    }

    public boolean isBiggerPosition(final int position) {
        return this.position > position;
    }


    public void printName() {
        System.out.print(name);
    }

    @Override
    public String toString() {
        String positionString = "";
        for (int i = 0; i < position; i++) {
            positionString += "-";
        }
        return name + " : " + positionString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}