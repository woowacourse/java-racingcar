package racingcar.domain.data;

import racingcar.domain.RandomNumberRuleStrategy;

public class Car {
    private static RandomNumberRuleStrategy rule;
    private final Name name;
    private final Position position;

    public Car(final String name, final RandomNumberRuleStrategy randomNumberRule) {
        this.name = new Name(name);
        this.position = new Position(0);
        this.rule = randomNumberRule;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (rule.execute()) {
            position++;
        }
    }

    public int aboveMaxPosition(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }

    public boolean isMaxPosition(int maxPosition) {
        if (maxPosition == this.position) {
            return true;
        }
        return false;
    }
}
