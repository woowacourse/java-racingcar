package racingcar.dto;

import racingcar.domain.car.Car;
import racingcar.utils.Delimiter;

public class CarStatusDto {

    private final String name;
    private final int location;

    public CarStatusDto(final String name, final int location) {
        this.name = name;
        this.location = location;
    }

    public static CarStatusDto toDto(final Car car) {
        return new CarStatusDto(car.getName(), car.getLocation());
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        return Delimiter.concatWithColon(name, Delimiter.repeatUnderBar(location));
    }

}
