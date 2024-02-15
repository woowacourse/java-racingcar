package domain;

public class CarStatusResponse {
    private final String name;
    private final int distance;

    public CarStatusResponse(Car car) {
        this.name = car.getName();
        this.distance = car.getDistance();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
