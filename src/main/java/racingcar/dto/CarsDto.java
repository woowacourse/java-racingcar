package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class CarsDto {
    private final List<CarDto> carDtoList;
    private final int currentRound;

    public CarsDto(List<CarDto> carDtos, int currentRound) {
        this.carDtoList = carDtos;
        this.currentRound = currentRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public List<CarDto> getCarDtoList() {
        return Collections.unmodifiableList(carDtoList);
    }
}
