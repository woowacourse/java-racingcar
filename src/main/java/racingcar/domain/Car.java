package racingcar.domain;

public class Car {
    private static final String BLANK = " ";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final int INIT_POSITION = 0;
    private static final int MOVABLE_VALUE = 4;

    private int position;
    private final String name;

    public Car(String name) {
        validateBlankInName(name);
        this.name = name;
        this.position = INIT_POSITION;
    }

    private void validateBlankInName(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    private boolean isMovable(int number) {
        return number >= MOVABLE_VALUE;
    }

    public boolean isSamePosition(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
