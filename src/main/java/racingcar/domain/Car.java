package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private CarName name;
    private int position;

    public Car(CarName name) {
        this.name = name;
        position = INITIAL_POSITION;
    }

    public void move(MoveNumber number) {
        if (number.isMovable()) {
            position++;
        }
    }

    boolean isWinner(int winnerPosition) {
        return winnerPosition == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

}
