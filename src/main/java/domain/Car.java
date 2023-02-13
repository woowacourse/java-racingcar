package domain;

public class Car {

    private static final int MOVING_STANDARD_NUM = 4;
    private static final int ADD_POSITION = 1;
    private static final int INIT_POSITION = 0;
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private int position = INIT_POSITION;

    public Car(String name) {
        validateNameLength(name.length());
        this.name = name;
    }

    public void move(int number) {
        if (isAllowedToMove(number)) {
            this.position += ADD_POSITION;
        }
    }

    private void validateNameLength(int nameSize) {
        if (nameSize < MIN_NAME_LENGTH || nameSize > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 1에서 5사이의 이름 길이만 입력 가능합니다.");
        }
    }

    private boolean isAllowedToMove(int number) {
        return number >= MOVING_STANDARD_NUM;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;

    }
}
