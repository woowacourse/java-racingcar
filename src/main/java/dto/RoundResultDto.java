package dto;

import domain.Cars;
import java.util.List;

public class RoundResultDto {

    private final List<CarDto> roundResult;

    public RoundResultDto(List<CarDto> roundResult) {
        this.roundResult = roundResult;
    }

    public static RoundResultDto from(Cars cars) {
        return new RoundResultDto(cars.getCars().stream()
                .map(CarDto::from)
                .toList());
    }

    public List<CarDto> getRoundResult() {
        return roundResult;
    }
}
