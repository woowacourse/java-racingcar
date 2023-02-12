package racingcar.domain;

import racingcar.domain.dto.CarRaceDto;
import racingcar.domain.dto.RaceResultDto;
import racingcar.domain.wrapper.RaceCount;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final RaceCount raceCount;

    private Race(final String raceCount) {
        this.raceCount = RaceCount.createRaceCount(raceCount);
    }

    public static Race createRace(final String raceCount) {
        return new Race(raceCount);
    }

    public List<RaceResultDto> getRaceResults(final Cars cars) {
        List<RaceResultDto> raceResults = new ArrayList<>();
        for (int i = 0; i < raceCount.getCount(); i++) {
            List<CarRaceDto> carRaceResult = cars.race();
            RaceResultDto raceResult = RaceResultDto.createRaceResultDto(carRaceResult);
            raceResults.add(raceResult);
        }
        return raceResults;
    }
}
