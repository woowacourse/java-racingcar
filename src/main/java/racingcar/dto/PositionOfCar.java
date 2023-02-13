package racingcar.dto;

import racingcar.domain.Car;

public class PositionOfCar {

    private final String carName;
    private final int position;

    public PositionOfCar(final String carName, final int position) {
        this.carName = carName;
        this.position = position;
    }

    public static PositionOfCar from(final Car car) {
        return new PositionOfCar(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
