package racingcar.model;

public class Car {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MOVING_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "[ERROR] 자동차 이름은 최소 " + MINIMUM_NAME_LENGTH + "글자, 최대 " + MAXIMUM_NAME_LENGTH + "글자까지 가능해요.");
        }
    }

    public void move(int movingCondition) {
        if (movingCondition >= MOVING_CONDITION) {
            position++;
        }
    }

    public int findGreaterPosition(int position) {
        return Math.max(this.position, position);
    }

    public boolean isPosition(int winnerPosition) {
        return winnerPosition == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
