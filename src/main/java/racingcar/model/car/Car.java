package racingcar.model.car;

import racingcar.util.RandomNumber;
import racingcar.util.RandomUtil;

import java.util.Objects;

public class Car {
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
        return new Car(Name.from(name), Position.from(0), new RandomNumber());
    }

    public static Car of(String name, int position, RandomUtil randomUtil) {
        return new Car(Name.from(name), Position.from(position), randomUtil);
    }

    public void move() {
        if (randomUtil.createRandom(MIN_RANDOM_BOUND, MAX_RANDOM_BOUND) >= MIN_MOVABLE_VALUE) {
            position = position.increase();
        }
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
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, position);
    }
}
