package racingcar.domain.dto;

import java.util.List;

public class RaceResultDto {

    private final List<CarStatusDto> carRaceResults;

    private RaceResultDto(final List<CarStatusDto> carRaceResults) {
        this.carRaceResults = carRaceResults;
    }

    public static RaceResultDto create(final List<CarStatusDto> carRaceResult) {
        return new RaceResultDto(carRaceResult);
    }

    public List<CarStatusDto> getCarRaceResults() {
        return carRaceResults;
    }
}
