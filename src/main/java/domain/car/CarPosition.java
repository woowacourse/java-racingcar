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

    public int getPosition() {
        return position;
    }
}
