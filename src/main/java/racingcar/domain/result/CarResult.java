package racingcar.domain.result;

import racingcar.domain.car.Car;

public record CarResult(String name, int position) {

    public static CarResult from(final Car car) {
        return new CarResult(car.getName(), car.getPosition());
    }
}
