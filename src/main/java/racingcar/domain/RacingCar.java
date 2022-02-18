package racingcar.domain;

public class RacingCar implements Comparable<RacingCar> {

    private static final int START_POSITION = 0;
    private static final int MOVE_STANDARD = 4;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String EXCEPTION_NO_NAME = "[ERROR] 자동차 이름은 반드시 존재해야 합니다.\n";
    private static final String EXCEPTION_TOO_LONG_NAME = "[ERROR] 자동차 이름은 5자 이하여야 합니다.\n";
    private final String name;
    private int position;

    public RacingCar(String name) {
        validateName(name);
        this.position = START_POSITION;
        this.name = name;
    }

    public void validateName(String name) {
        checkCarNameIsEmpty(name);
        checkCarNameSize(name);
    }

    private void checkCarNameIsEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_NO_NAME);
        }
    }

    private void checkCarNameSize(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_TOO_LONG_NAME);
        }
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
        return this.position == racingCar.getPosition();
    }

    @Override
    public int compareTo(RacingCar otherCar) {
        return this.position - otherCar.position;
    }
}
