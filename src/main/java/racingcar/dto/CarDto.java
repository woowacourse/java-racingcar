package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {

    private String carName;
    private int position;

    public CarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public static CarDto of(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
