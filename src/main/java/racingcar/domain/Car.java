package racingcar.domain;

public class Car {

    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int REQUIRED_NUMBER_OF_POWER = 4;
    private static final String INVALID_CAR_NAME_LENGTH = "이름은 1자 이상 5자 이내로 입력해 주세요.";

    private final String name;
    private int movedDistance = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH_OF_NAME || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }

    public void goIfNumberOfPowerEnough(int numberOfPower) {
        if (numberOfPower >= REQUIRED_NUMBER_OF_POWER) {
            movedDistance++;
        }
    }

    public boolean isSameDistance(int distance) {
        return distance == movedDistance;
    }

    public String getName() {
        return name;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
