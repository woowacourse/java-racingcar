package racingcar.domain.car;

public class CarPosition {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition move() {
        return new CarPosition(position + 1);
    }

    public boolean equalToPosition(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }
}
