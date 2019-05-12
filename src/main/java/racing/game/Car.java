package racing.game;

import java.util.List;

public class Car {
    private static final int NAME_LENGTH_MIN_LIMIT = 1;
    private static final int NAME_LENGTH_MAX_LIMIT = 6;

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

    private boolean checkRepetition(List<Car> cars) {
        for (Car car : cars) {
            if (car.matchCarName(name))
                return true;
        }
        return false;
    }

    private boolean matchCarName(String name) {
        return this.name == name;
    }

    void move() {
        position++;
    }

    public String showPosition() {
        String carPositionString = name + " : ";
        for (int i = 0; i < position; i++) {
            carPositionString += '-';
        }

        return carPositionString;
    }

    public int compareTo(Car o2) {
        if (this.position == o2.position) {
            return 0;
        }
        if (this.position > o2.position) {
            return 1;
        }
        return -1;
    }

    public String getName() {
        return name;
    }
}
