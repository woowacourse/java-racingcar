package racingcar.domain.data;

import racingcar.domain.RandomNumberRuleStrategy;

import java.util.Objects;

public class Car {
    private final Name name;
    private static RandomNumberRuleStrategy rule;
    private Position position;

    public Car(final String name, final RandomNumberRuleStrategy randomNumberRule) {
        this.name = new Name(name);
        this.position = new Position(0);
        this.rule = randomNumberRule;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.value();
    }

    public void move() {
        if (rule.execute()) {
            position = position.move();
        }
    }

    public int aboveMaxPosition(int maxPosition) {
        if (position.isBigger(maxPosition)) {
            return position.value();
        }
        return maxPosition;
    }

    public boolean isMaxPosition(int maxPosition) {
        if (position.isSameAs(maxPosition)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
