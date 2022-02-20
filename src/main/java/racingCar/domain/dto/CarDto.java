package racingCar.domain.dto;

import java.util.Objects;
import racingCar.domain.Car;

public class CarDto {
    public final String name;
    public int position;

    public CarDto(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
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

    @Override
    public String toString() {
        return "CarDTO{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}