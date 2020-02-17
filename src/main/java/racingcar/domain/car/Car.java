package racingcar.domain.car;

import racingcar.domain.RandomNumber;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

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

    public int getLocation() {
        return location.getLocation();
    }

    public void play() {
        RandomNumber randomNumber = new RandomNumber();
        int randomNo = randomNumber.getRandomNumber();
        if (randomNumber.canMove(randomNo)) {
            move();
        }
    }

    private void move() {
        location.moveForward();
    }

    public String getName() {
        return name.toString();
    }

    public String getLocationMarks() { return location.toString(); }

    public boolean isLocation(int maxLocation) {
        return this.location.equals(new Location(maxLocation));
    }
}
