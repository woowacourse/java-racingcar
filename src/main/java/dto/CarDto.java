package dto;

public class CarDto {
    private final String name;
    private final int distance;

    private CarDto(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public static CarDto of(String name, int distance) {
        return new CarDto(name, distance);
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
