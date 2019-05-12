package domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int NAME_MAX_LENGTH  = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        validateName(name);

        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if ((name.length() > NAME_MAX_LENGTH) || (name.length() < 1)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하 입니다.");
        }
    }

    public int move(Rule rule) {

        this.position = this.position + rule.getAugmenter();

        return position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    @Override
    public int compareTo(Car car) {
        if (this.position < car.getPosition()) {
            return 1;
        }
        if (this.position > car.getPosition()) {
            return -1;
        }
        return 0;
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
