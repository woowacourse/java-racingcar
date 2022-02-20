package racingcar.domain;

public class Car {
    public static final String ERROR_EMPTY_NAME = "[ERROR] 빈 이름이 있습니다.";
    public static final String ERROR_LONG_NAME = "[ERROR] 이름을 5자 이하로 등록해주세요";

    private static final int MOVE_CONDITION = 4;
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;
    private int position;

    public Car(String name, int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    private void validateCarName(String carName) {
        checkEmptyName(carName);
        checkLongName(carName);
    }

    private void checkEmptyName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    private void checkLongName(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_LONG_NAME);
        }
    }

    public void move(int value) {
        if (value >= MOVE_CONDITION) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
