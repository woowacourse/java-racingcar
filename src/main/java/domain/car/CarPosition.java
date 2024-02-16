package domain.car;

import java.util.Objects;

public final class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public void move(int distance) {
        this.position += distance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof CarPosition carPosition)) {
            return false;
        }

        return this.position == carPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
