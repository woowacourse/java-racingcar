package racing.view.dto;

import racing.domain.Car;

public class CarMoveStatusDto {
    private String carName;
    private int position;

    private CarMoveStatusDto(final String carName, final int position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarMoveStatusDto of(final Car car) {
        return new CarMoveStatusDto(car.getName(), car.getPositionValue());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
