package dto;

import java.util.List;

public class RoundResultDto {

    private final List<CarDto> roundResult;

    public RoundResultDto(List<CarDto> roundResult) {
        this.roundResult = roundResult;
    }

    public List<CarDto> getRoundResult() {
        return roundResult;
    }
}
