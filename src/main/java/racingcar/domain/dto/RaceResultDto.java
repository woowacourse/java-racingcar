package racingcar.domain.dto;

import java.util.List;

public class RaceResultDto {

    private final List<CarRaceDto> carRaceResult;

    private RaceResultDto(final List<CarRaceDto> carRaceResult) {
        this.carRaceResult = carRaceResult;
    }

    public static RaceResultDto of(final List<CarRaceDto> carRaceDtos) {
        return new RaceResultDto(carRaceDtos);
    }

    public List<CarRaceDto> getCarRaceResult() {
        return carRaceResult;
    }
}
