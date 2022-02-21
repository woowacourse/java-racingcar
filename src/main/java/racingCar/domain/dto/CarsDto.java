package racingCar.domain.dto;

import java.util.List;
import java.util.Objects;

public class CarsDto {
    private final List<CarDto> carsDto;

    public CarsDto(List<CarDto> carsDto) {
        this.carsDto = carsDto;
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
