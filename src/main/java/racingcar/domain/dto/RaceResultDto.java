package racingcar.domain.dto;

import java.util.List;

public class RaceResultDto {

    private final List<CarStatusDto> carRaceResult;

    private RaceResultDto(final List<CarStatusDto> carRaceResult) {
        this.carRaceResult = carRaceResult;
    }

    public static RaceResultDto createRaceResultDto(final List<CarStatusDto> carRaceResult) {
        return new RaceResultDto(carRaceResult);
    }

    public List<CarStatusDto> getCarRaceResult() {
        return carRaceResult;
    }
}
