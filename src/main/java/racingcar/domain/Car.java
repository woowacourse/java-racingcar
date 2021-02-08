package racingcar.domain;

import racingcar.utils.exception.InvalidNameLengthException;

public class Car {
    private static int NAME_MAX_LENGTH = 5;
    private static RandomNumberRuleStrategy rule;
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        isValidNameLength();
        setStrategy(new RandomNumberRule());
    }

    public void setStrategy(RandomNumberRuleStrategy randomNumberRule) {
        this.rule = randomNumberRule;
    }

    private void isValidNameLength() {
        if (name.length() <= 0 || name.length() > NAME_MAX_LENGTH) {
            throw new InvalidNameLengthException(NAME_MAX_LENGTH);
        }
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if (rule.execute()) {
            position++;
        }
    }

    public String toString() {
        return this.name + " : " + repeat("-", this.position);
    }

    private String repeat(String str, int num) {
        return new String(new char[num]).replace("\0", str);
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
