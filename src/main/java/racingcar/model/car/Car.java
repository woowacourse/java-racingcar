package racingcar.model.car;

import racingcar.util.RandomNumber;
import racingcar.util.RandomUtil;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MIN_RANDOM_BOUND = 0;
    private static final int MAX_RANDOM_BOUND = 9;
    private static final int MIN_MOVABLE_VALUE = 4;


    private final Name name;
    private final RandomUtil randomUtil;
    private Position position;

    private Car(Name name, Position position, RandomUtil randomUtil) {
        this.name = name;
        this.position = position;
        this.randomUtil = randomUtil;
    }

    public static Car from(String name) {
        return new Car(Name.from(name), Position.create(), new RandomNumber());
    }

    public static Car of(String name, int position, RandomUtil randomUtil) {
        return new Car(Name.from(name), Position.from(position), randomUtil);
    }

    public static Car of(String name, int position) {
        return new Car(Name.from(name), Position.from(position), new RandomNumber());
    }

    public void move() {
        if (randomUtil.createRandom(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND) >= MIN_MOVABLE_VALUE) {
            position = position.increase();
        }
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, position);
    }
}
