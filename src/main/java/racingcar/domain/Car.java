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

    int getPosition() {
        return position;
    }

    String getName() {
        return name.getName();
    }

    @Override
    public String toString() {
        StringBuilder trace = new StringBuilder();
        for (int i = 0; i < position; i++) {
            trace.append("-");
        }

        return name + ": " + trace.toString();
    }

}
