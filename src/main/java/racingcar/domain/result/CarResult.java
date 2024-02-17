package racingcar.domain.result;

import racingcar.domain.car.Car;

public class CarResult {

    private final String carName;
    private final int position;

    private CarResult(final String carName, final int position) {
        this.carName = carName;
        this.position = position;
    }

    public static CarResult from(final Car car) {
        return new CarResult(car.getName(), car.getPosition());
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

}
