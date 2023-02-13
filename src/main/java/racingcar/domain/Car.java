package racingcar.domain;

public class Car {

    private static final int MOVING_CONDITION = 4;

    private Name name;
    private int position = 0;

    public Car(String name) {
        this.name = new Name(name);
    }

    public void move(int movingCondition) {
        if (movingCondition >= MOVING_CONDITION) {
            position++;
        }
    }

    public int findGreaterPosition(int position) {
        return Math.max(this.position, position);
    }

    public boolean isSamePosition(int winnerPosition) {
        return winnerPosition == position;
    }

    public String getName() {
        return name.getName();
    }

    public String getResult(String positionSign) {
        return name.getName() + " : " + positionSign.repeat(Math.max(0, position));
    }
}
