package racing.game;

import java.util.List;

public class Car {
    private static final int NAME_LENGTH_MIN_LIMIT = 1;
    private static final int NAME_LENGTH_MAX_LIMIT = 6;
    private static final int BOUNDARY = 4;

    private final String name;
    private int position = 0;

    public Car(final String name) throws Exception {
        this.name = name.trim();
        if (checkNull(name) || checkInvalidNameLength(name))
            throw new Exception();
    }

    public Car(final String name, List<Car> cars) throws Exception {
        this.name = name.trim();
        if (checkNull(name) || checkInvalidNameLength(name) || checkRepetition(cars))
            throw new Exception();
    }

    static boolean checkNull(Object name) {
        return name == null;
    }

    static boolean checkInvalidNameLength(String name) {
        return name.length() < NAME_LENGTH_MIN_LIMIT || name.length() >= NAME_LENGTH_MAX_LIMIT;
    }

    boolean checkRepetition(List<Car> cars) {
        for (Car car : cars) {
            if (car.matchCarName(name))
                return true;
        }
        return false;
    }

    boolean matchCarName(String name) {
        return this.name.equals(name);
    }

    boolean move(int randomValue) {
        if (randomValue >= BOUNDARY) {
            position++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String carPosition = name + " : ";
        for (int i = 0; i < position; i++) {
            carPosition += '-';
        }
        return carPosition;
    }

    public String getName() {
        return name;
    }

    public int matchPosition(int position) {
        if (this.position > position)
            return 1;
        if (this.position == position)
            return 0;
        return -1;
    }

    public int getPosition() {
        return position;
    }
}
