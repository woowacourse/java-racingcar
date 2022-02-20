package racingcargame.model.car.vo;

public class CarPosition implements Comparable<CarPosition> {
    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public void move(final int moveValue) {
        position += moveValue;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(final CarPosition winnerCarPosition) {
        return this.position - winnerCarPosition.position;
    }
}
