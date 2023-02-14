package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {
    private final String name;
    private final int movedCount;

    public CarDto(Car car) {
        this.name = car.getName();
        this.movedCount = car.getMovedCount();
    }

    public String getName() {
        return name;
    }

    public int getMovedCount() {
        return movedCount;
    }
}
