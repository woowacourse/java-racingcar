package racingcar.domain;

public class Car {
    private static final String CAR_STATUS_DELIMITER = " : ";
    private static final String CAR_POSITION_STATUS = "-";

    private String name;
    private int position;
    private CarMoveRuleStrategy rule;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.rule = new CarMoveRule();
    }

    public String getName() {
        return this.name;
    }

    public void move() {
        if (rule.execute()) {
            position++;
        }
    }

    public String toString() {
        return this.name + CAR_STATUS_DELIMITER + repeat(CAR_POSITION_STATUS, this.position);
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
