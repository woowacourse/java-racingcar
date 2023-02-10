package car.domain;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;
    private static final String NAME_LENGTH_EXCEPTION_FORMAT = "이름은 %d글자 이상 %d글자 이하입니다";
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = String.format(NAME_LENGTH_EXCEPTION_FORMAT,
            MIN_NAME_LENGTH,
            MAX_NAME_LENGTH);

    private final String name;
    private int position;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        validateNameLength(name);
        validatePosition(position);
        this.name = name;
        this.position = position;
    }

    public boolean isFartherThan(Car other) {
        return position > other.position;
    }

    public boolean hasSamePositionWith(Car other) {
        return position == other.position;
    }

    public void move(MoveChance moveChance) {
        if (moveChance.isMovable()) {
            position++;
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private void validatePosition(int position) {
        if (position < START_POSITION) {
            throw new IllegalArgumentException("[ERROR] 위치는 시작점보다 작으면 안됩니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
