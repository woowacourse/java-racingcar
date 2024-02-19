package domain.car;

public final class CarPosition {
    private int value;

    public CarPosition(int value) {
        this.value = value;
    }

    public void move(int distance) {
        this.value += distance;
    }

    public int getValue() {
        return value;
    }
}
