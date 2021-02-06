package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class CarsDTO {
    private final List<CarDTO> cars;

    public CarsDTO(List<CarDTO> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }
    
    public List<CarDTO> toList() {
        return cars;
    }
}
