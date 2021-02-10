package racingcar.domain.car;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static boolean checkMaxName(Car car) {
        return car.name.length() <= MAX_NAME_LENGTH;
    }

    public void tryToMoveForward(int fuel) {
        if (fuel >= MOVE_CONDITION) {
            ++position;
        }
    }

    public boolean isMaxPosition(int maxDistance) {
        return position == maxDistance;
    }
}
