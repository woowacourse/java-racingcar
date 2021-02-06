package racingcar.domain;

public class Car {

    private static final int MOVABLE_MINIMUM_RPM = 4;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    public void tryToMove(int currentRPM) {
        if (movementCheck(currentRPM)) {
            move();
        }
    }

    private boolean movementCheck(int currentRPM) {
        return currentRPM >= MOVABLE_MINIMUM_RPM;
    }

    private void move() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(
                "자동차 이름은 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이하로 입력해주세요.");
        }
    }
}
