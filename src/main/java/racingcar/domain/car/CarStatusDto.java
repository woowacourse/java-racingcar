package racingcar.domain.car;

import racingcar.utils.Delimiter;

public class CarStatusDto {

    private String name;
    private int location;

    public CarStatusDto(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public static CarStatusDto toDto(Car car) {
        return new CarStatusDto(car.getName(), car.getLocation());
    }

    @Override
    public String toString() {
        return Delimiter.concatWithColon(name, Delimiter.repeatUnderBar(location));
    }

}
