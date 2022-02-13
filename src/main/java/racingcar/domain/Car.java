package racingcar.domain;

public class Car {

    private static final int CAN_GO_VALUE = 4;
    private static final int POSITION_INCREMENT_UNIT = 1;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void goOrNot(int number) {
        if (canGo(number)) {
            go();
        }
    }

    private void go() {
        position += POSITION_INCREMENT_UNIT;
    }

    private boolean canGo(int number) {
        return number >= CAN_GO_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int winnerPosition) {
        return position == winnerPosition;
    }
}
