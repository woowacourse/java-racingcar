package racingcar.dto;

import racingcar.domain.car.Car;

public class WinnerCarDto {
    private final String name;

    public WinnerCarDto(Car car) {
        this.name = car.getName();
    }

    public String getName() {
        return name;
    }
}
