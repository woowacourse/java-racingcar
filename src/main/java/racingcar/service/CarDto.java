package racingcar.service;

import racingcar.model.car.Car;

import java.util.Objects;

public class CarDto {
    private final String name;
    private final int position;

    public CarDto(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public CarDto(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CarDto carDto = (CarDto) o;
        return position == carDto.position && Objects.equals(name, carDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
