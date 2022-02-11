package racingcar.domain;

public class Car {
    private static final int MINIMUM_DRIVE_CONDITION = 4;
    private static final int DEFAULT_POSITION_VALUE = 0;

    private final String name;
    private int position = DEFAULT_POSITION_VALUE;

    public Car(String name) {
        this.name = name;
    }

    public void drive(int value) {
        if (MINIMUM_DRIVE_CONDITION <= value) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
