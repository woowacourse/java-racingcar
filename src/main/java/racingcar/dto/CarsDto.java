package racingcar.dto;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CarsDTO.java
 * Cars 클래스에 대해 Layer간 데이터 전송을 위한 DTO 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class CarsDto {
    private final List<CarDto> cars;

    private CarsDto(List<CarDto> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public static CarsDto of(List<Car> cars) {
        return new CarsDto(cars.stream()
                .map(Car::toDto)
                .collect(Collectors.toList()));
    }

    public List<CarDto> toList() {
        return cars;
    }
}
