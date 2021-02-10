package racingcar.domain;

public class Car {
    private static final int MOVE_PIVOT = 4;
    private Name name;
    private int position;

    public Car(final Name name) {
        this.name = name;
    }

    public Name getName() {
        return this.name;
    }

    public void carMove(final int number) {
        if (number > MOVE_PIVOT) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isWinnerPosition(final int winnerPosition) {
        return this.position == winnerPosition;
    }
}
