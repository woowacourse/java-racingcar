package domain;

public class Car implements Comparable<Car>{
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final String name;

    private int position = 0;
    public Car(String name) {
        validate(name);
        this.name = name;
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

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[Error] 이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. " +
                    "입력값 : "  + name);
        }
    }

}
