package racingcar.domain;

import java.util.Objects;
import java.util.Random;

public class Car {
    private final static int RANDOM_NUMBER_OFFSET = 10;
    private final static int MOVE_OFFSET = 4;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        if (isPossibleMove()) {
            this.position++;
        }
    }

    public void move(int num) { //테스트 코드를 위한 코드
        if (isPossibleMove(num)) {
            this.position++;
        }
    }

    private boolean isPossibleMove(int num) { //테스트 코드를 위한 코드
        return num > MOVE_OFFSET;
    }

    private boolean isPossibleMove() {
        return generateRandomNumber() > MOVE_OFFSET;
    }

    private int generateRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_OFFSET);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
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

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
