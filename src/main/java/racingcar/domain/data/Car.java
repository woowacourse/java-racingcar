package racingcar.domain.data;

import racingcar.domain.RandomNumberRuleStrategy;

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
}
