package racingCar.domain.dto;

import java.util.Objects;
import racingCar.domain.Car;

public class CarDto {
    private final String name;
    private final int position;

    private CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public static CarDto of(String name, int position) {
        return new CarDto(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDto carDTO = (CarDto) o;
        return position == carDTO.position && Objects.equals(name, carDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}