package racingCar.model;

public class Position {
    private int position = 0;

    public void move() {
        position++;
    }

    public int get() {
        return position;
    }

    public boolean isSame(int position) {
        return this.position == position;
    }
}