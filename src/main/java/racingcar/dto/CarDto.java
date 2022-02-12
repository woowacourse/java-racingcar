package racingcar.dto;

import java.util.Objects;

public class CarDto {
    private final String carName;
    private final int distance;

    public CarDto(final String carName, final int distance){
        this.carName = carName;
        this.distance = distance;
    }

    public String carName() {
        return carName;
    }

    public int distance() {
        return distance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return distance == carDto.distance && Objects.equals(carName, carDto.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }
}
