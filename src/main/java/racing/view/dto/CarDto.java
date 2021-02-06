package racing.view.dto;

import racing.domain.Car;

public class CarDto {
    private String carName;
    private int position;

    private CarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarDto of(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
