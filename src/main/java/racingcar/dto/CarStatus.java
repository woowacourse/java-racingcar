package racingcar.dto;

public class CarStatus {
    private final String name;
    private final int currentPoint;

    public CarStatus(String name, int currentPoint) {
        this.name = name;
        this.currentPoint = currentPoint;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPoint() {
        return currentPoint;
    }
}
