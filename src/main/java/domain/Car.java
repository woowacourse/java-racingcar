package domain;

public class Car implements Comparable<Car> {

    public static final String BLANK = " ";
    public static final int DEFAULT_POSITION_VALUE = 0;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MINIMUM_NUMBER_TO_MOVE = 4;
    public static final String NAME_LENGTH_EXCEPTION_MESSAGE = "이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. ";
    public static final String BLANK_CONTAIN_NAME_EXCEPTION_MESSAGE = "이름에 공백을 포함할 수 없습니다.";

    private final String name;
    private int position = DEFAULT_POSITION_VALUE;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateToContainBlank(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE + "입력값 : "  + name);
        }
    }

    private void validateToContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_CONTAIN_NAME_EXCEPTION_MESSAGE + "입력값 : " + name);
        }
    }

    public void move(int number) {
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position++;
        }
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
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
