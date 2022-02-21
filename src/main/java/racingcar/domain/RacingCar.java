package racingcar.domain;

public class RacingCar implements Comparable<RacingCar> {

    private static final int START_POSITION = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String EXCEPTION_NAME_RULE = "[ERROR] 자동차 이름은 반드시 존재해야하며 5자 이하여야 합니다.\n";
    private final String name;
    private int position;

    public RacingCar(String name) {
        validateName(name);
        this.position = START_POSITION;
        this.name = name;
    }

    public void validateName(String name) {
        if (isCarNameEmpty(name) || isCarNameSizeOverLimit(name)) {
            throw new IllegalArgumentException(EXCEPTION_NAME_RULE);
        }
    }

    private boolean isCarNameEmpty(String name) {
        if (name == null || name.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean isCarNameSizeOverLimit(String name) {
        if (name == null || name.length() > MAXIMUM_NAME_LENGTH) {
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void goOrStay(int randomNumber) {
        if (randomNumber >= MOVE_STANDARD) {
            position++;
        }
    }

    public boolean isSamePosition(RacingCar racingCar) {
        if (compareTo(racingCar) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(RacingCar otherCar) {
        return this.position - otherCar.position;
    }
}
