package domain;

public class Car implements Comparable<Car> {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_LOWER_BOUND_INCLUSIVE = 4;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "자동차의 이름은 1 ~ 5 글자여야 합니다";

    private final String name;
    private int position = 0;

    public Car(String input) {
        validateName(input);
        this.name = input;
    }

    public void move(int number) {
        if (number >= MOVE_LOWER_BOUND_INCLUSIVE)
            position++;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
