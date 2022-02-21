package racingCar.domain.dto;

import java.util.List;
import java.util.Objects;
import racingCar.domain.Cars;

public class CarsDto {
    private final List<CarDto> carsDto;

    private CarsDto(List<CarDto> carsDto) {
        this.carsDto = carsDto;
    }

    public static CarsDto from(Cars cars) {
        return new CarsDto(cars.getDto());
    }

    public static CarsDto of(List<CarDto> carsDto) {
        return new CarsDto(carsDto);
    }

    public List<CarDto> getCarsDto() {
        return carsDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarsDto carsDto1 = (CarsDto) o;
        return Objects.equals(carsDto, carsDto1.carsDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsDto);
    }

    @Override
    public String toString() {
        return "CarsDto{" +
                "carsDto=" + carsDto +
                '}';
    }
}
