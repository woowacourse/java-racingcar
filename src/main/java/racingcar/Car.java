package racingcar;

import java.util.Objects;

public class Car {
    private static final int RANDOM_NUMBER_LIMIT = 10;
    private static final int FORWARD_NUM = 4;
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        checkName(name);
        this.name = name.trim();
        this.position = position;
    }

    private void checkName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private int makeRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_LIMIT);
    }

    protected void move(int number) {
        position += (number >= FORWARD_NUM) ? 1 : 0;
    }

    public void play() {
        int randomNumber = makeRandomNumber();
        move(randomNumber);
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
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
