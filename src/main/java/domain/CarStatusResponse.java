package domain;

public class CarStatusResponse {
    private final String name;
    private final int distance;

    public CarStatusResponse(Car car) {
        this.name = car.getName().getName();
        this.distance = car.getDistance().getDistance();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
