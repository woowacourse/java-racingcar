package racingCar.domain;

import java.util.Objects;

public class CarDTO {
    public final String name;
    public int position;

    public CarDTO(Car car) {
        this.name = car.name.toString();
        this.position = car.position.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDTO carDTO = (CarDTO) o;
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