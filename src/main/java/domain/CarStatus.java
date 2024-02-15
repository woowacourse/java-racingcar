package domain;

public class CarStatus {
    private final String name;
    private final int distance;

    public CarStatus(Car car) {
        this.name = car.getName().getName();
        this.distance = car.getDistance().getDistance();
    }

    public static CarStatus of(Car car) {
        return new CarStatus(car);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
