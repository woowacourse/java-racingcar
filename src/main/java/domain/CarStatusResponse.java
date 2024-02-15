package domain;

public class CarStatusResponse {
    private final String name;
    private final Distance distance;

    public CarStatusResponse(Car car) {
        this.name = car.getName();
        this.distance = car.getDistance();
    }

    public String getName() {
        return name;
    }

    public Distance getDistance() {
        return distance;
    }
}
