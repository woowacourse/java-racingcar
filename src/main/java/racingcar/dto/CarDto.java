package racingcar.dto;

import racingcar.model.Car;

public record CarDto(String name, int position) {

    public static CarDto from(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
