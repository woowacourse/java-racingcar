package dto.response;

import domain.Car;

public class CarStatusDto {

    private final String name;
    private final int position;

    private CarStatusDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarStatusDto of(Car car) {
        return new CarStatusDto(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
