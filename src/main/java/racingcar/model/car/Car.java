package racingcar.model.car;

public class Car {
    private static final String POSITION_FORMAT_SYMBOL = "-";
    private final String carName;
    private int position = 1;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        this.carName = carName;
        this.movingStrategy = movingStrategy;
    }

    public void moveForward() {
        position++;
    }

    public String getCurrentStateFormat() {
        String stateFormat = "%s : %s";
        String positionFormat = POSITION_FORMAT_SYMBOL.repeat(position);
        return String.format(stateFormat, carName, positionFormat);
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

    public String getWinnerCarNameFormat() {
        return this.carName;
    }

    public boolean movable() {
        return this.movingStrategy.movable();
    }
}
