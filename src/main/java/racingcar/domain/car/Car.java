package racingcar.domain.car;

public class Car {

    public static final int MAX_NAME_LENGTH = 5;
    public static final int MOVE_CONDITION = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean checkPosition(int guessPosition) {
        return position == guessPosition;
    }

    public static boolean checkMaxName(Car car) {
        return car.name.length() <= MAX_NAME_LENGTH;
    }

    public void tryToMoveForward(int randomInteger) {
        if (randomInteger >= MOVE_CONDITION) {
            ++position;
        }
    }
}
