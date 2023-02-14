package racingcar.dto;

public class CarStatus {
    private final String name;
    private final int currentPosition;

    public CarStatus(final String name, final int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
