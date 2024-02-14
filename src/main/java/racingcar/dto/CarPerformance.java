package racingcar.dto;

public class CarPerformance {
    private final String carName;
    private final int distance;

    public CarPerformance(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
