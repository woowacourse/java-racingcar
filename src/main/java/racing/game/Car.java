package racing.game;

import java.util.Objects;

public class Car {
    private static final int NAME_LENGTH_MIN_LIMIT = 1;
    private static final int NAME_LENGTH_MAX_LIMIT = 6;
    private static final int BOUNDARY = 4;
    private static final String POSITION_MARK = "-";

    private final String name;
    private int position = 0;

    public Car(final String name) throws Exception {
        this.name = name.trim();
        if (checkNull(this.name) || checkInvalidNameLength(this.name))
            throw new Exception();
    }

    public Car(final String name, int position) throws Exception {
        this.name = name.trim();
        this.position = position;
        if (checkNull(this.name) || checkInvalidNameLength(this.name))
            throw new Exception();
    }

    static boolean checkNull(Object name) {
        return name == null;
    }

    static boolean checkInvalidNameLength(String name) {
        return name.length() < NAME_LENGTH_MIN_LIMIT || name.length() >= NAME_LENGTH_MAX_LIMIT;
    }

    boolean matchCarName(String name) {
        return this.name.equals(name);
    }

    void move(int randomValue) {
        if (randomValue >= BOUNDARY) {
            position++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.append(" : ");
        for (int i = 0; i < position; i++) {
            stringBuilder.append(POSITION_MARK);
        }
        return stringBuilder.toString();
    }

    String getName() {
        return name;
    }

    boolean matchPosition(int position) {
        return this.position == position;
    }

    int getPosition() {
        return position;
    }

    int compareTo(Car o2) {
        return Integer.compare(this.position, o2.position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
