package racingcargame.model.car.vo;

public class CarPosition {
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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CarPosition otherCarPosition = (CarPosition) o;
        return position == otherCarPosition.position;
    }

    @Override
    public int hashCode() {
        return position;
    }
}
