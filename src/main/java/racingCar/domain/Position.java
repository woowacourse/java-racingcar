package racingCar.domain;

public class Position {

    private int position;

    public Position(int initPosition) {
        this.position = initPosition;
    }

    public void increase() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
