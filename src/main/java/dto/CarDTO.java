package dto;

public class CarDTO {
    private final String name;
    private final int distance;

    private CarDTO(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public static CarDTO of(String name, int distance) {
        return new CarDTO(name, distance);
    }
}
