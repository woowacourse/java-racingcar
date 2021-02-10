package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class CarsDto {
    private final List<CarDto> carsDto;
    private final int currentRound;

    public CarsDto(List<CarDto> carsDto, int currentRound) {
        this.carsDto = carsDto;
        this.currentRound = currentRound;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public List<CarDto> getCarsDto() {
        return Collections.unmodifiableList(carsDto);
    }
}
