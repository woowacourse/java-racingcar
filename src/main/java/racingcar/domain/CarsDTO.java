package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CarsDTO.java
 * Cars 클래스에 대해 Layer간 데이터 전송을 위한 DTO 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class CarsDTO {
    private final List<CarDTO> cars;

    private CarsDTO(List<CarDTO> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public static CarsDTO of(List<Car> cars) {
        return new CarsDTO(cars.stream()
                .map(Car::toDTO)
                .collect(Collectors.toList()));
    }

    public List<CarDTO> toList() {
        return cars;
    }
}
