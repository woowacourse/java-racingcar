package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class CarsDto {
    public static final int ZERO = 0;
    private final List<CarDto> carDtoList;

    public CarsDto(List<CarDto> carDtos) {
        this.carDtoList = carDtos;
    }

    public List<CarDto> getCarDtoList() {
        return Collections.unmodifiableList(carDtoList);
    }
}
