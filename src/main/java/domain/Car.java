package domain;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_MOVABLE_NUM = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name.trim();
        this.position = 0;
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 0~5이여야 합니다.");
        }
    }

    public boolean move(int randomNumber) {
        if (randomNumber >= MIN_MOVABLE_NUM) {
            position++;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
