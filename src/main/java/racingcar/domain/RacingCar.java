package racingcar.domain;

public class RacingCar {

    private static final int NAME_MAX_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position = DEFAULT_POSITION;

    public RacingCar(String name) {
        isEmpty(name);
        checkNameLength(name);
        this.name = name;
    }

    private void isEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없다.");
        }
    }

    private void checkNameLength(String name) {
        if (name != null && name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveByCommand(boolean command) {
        if (command) {
            position++;
        }
    }

    public boolean isSamePosition(RacingCar anotherCar) {
        return this.position == anotherCar.getPosition();
    }

    public RacingCar getGreaterPositionCar(RacingCar anotherCar) {
        return this.position > anotherCar.getPosition() ? this : anotherCar;
    }
}
