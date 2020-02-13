package racingcar.domain.car;

import racingcar.domain.GoOrStop;

public class Car implements Comparable<Car> {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String IS = " : ";

    private final Name name;
    private Location location;

    public Car(String name) {
        validateEmptyName(name);
        validateNameLength(name);

        this.name = new Name(name);
        this.location = new Location();
    }

    public Car(String name, int location) {
        validateEmptyName(name);
        validateNameLength(name);

        this.name = new Name(name);
        this.location = new Location(location);
    }

    public static void validateEmptyName(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값은 빈 문자열일 수 없습니다.");
        }
    }

    public static void validateNameLength(String input) {
        if (isOverLength(input)) {
            throw new IllegalArgumentException("자동차의 이름은 5자이하만 가능합니다.");
        }
    }

    private static boolean isOverLength(String input) {
        return input.length() > MAX_NAME_LENGTH;
    }

    public void play() {
        if (GoOrStop.decideGoOrStop()) {
            move();
        }
    }

    private void move() {
        location.moveForward();
    }

    public String getRoundResult() {
        StringBuilder result = new StringBuilder();
        result.append(name);
        result.append(IS);
        result.append(location);
        return result.toString();
    }

    public boolean isAtSameLocation(Car anotherCar) {
        return this.location.compareTo(anotherCar.location) == 0;
    }

    @Override
    public int compareTo(Car anotherCar) {
        if (this.location.compareTo(anotherCar.location) > 0) {
            return 1;
        }

        if (this.location.compareTo(anotherCar.location) < 0) {
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
