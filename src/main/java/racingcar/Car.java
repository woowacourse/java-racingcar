package racingcar;

import java.util.stream.IntStream;

public class Car {

    public static final int RANDOM_MINIMUM_VALUE = 0;
    public static final int RANDOM_MAXIMUM_VALUE = 9;
    public static final int MOVE_FORWARD_BOUNDARY = 4;
    private Integer position;
    private final String name;

    private Car(final String name) {
        this.position = 1;
        this.name = name;
    }

    public static Car from(final String name) {
        return new Car(getValidatedName(name));
    }

    public void drive(final int randomValue) {
        if (randomValue < RANDOM_MINIMUM_VALUE || RANDOM_MAXIMUM_VALUE < randomValue) {
            throw new RuntimeException();
        }

        if (randomValue >= MOVE_FORWARD_BOUNDARY) {
            moveForward();
        }
    }

    private static String getValidatedName(String name) {
        name = name.trim();
        validateNameLength(name);
        validateNameNullOrEmpty(name);
        return name;
    }

    private static void validateNameNullOrEmpty(String name) {
        if (name == null || "".equals(name)) {
            throw new RuntimeException();
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new RuntimeException();
        }
    }

    private void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, getPositionToString());
    }

    private String getPositionToString() {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, position)
                .forEach(i -> sb.append("-"));
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + position.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.name.equals((car).name) && this.position.equals((car).position);
        }
        return false;
    }
}
