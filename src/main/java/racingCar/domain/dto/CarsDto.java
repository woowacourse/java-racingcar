package racingCar.domain.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingCar.domain.Car;

public class CarsDto {
    private final List<CarDto> carsDto;

    private CarsDto(List<CarDto> carsDto) {
        this.carsDto = carsDto;
    }

    public static CarsDto fromCars(List<Car> cars) {
        return new CarsDto(cars.stream()
                .map(CarDto::from)
                .collect(Collectors.toList())
        );
    }

    public static CarsDto fromCarDtos(List<CarDto> carDtos) {
        return new CarsDto(carDtos);
    }

    public List<CarDto> get() {
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
}