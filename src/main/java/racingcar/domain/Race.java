package racingcar.domain;

import racingcar.domain.dto.RaceResultDto;
import racingcar.domain.wrapper.RaceCount;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final RaceCount raceCount;

    private Race(final String raceCount) {
        this.raceCount = RaceCount.of(raceCount);
    }

    public static Race of(final String raceCount) {
        return new Race(raceCount);
    }

    public List<RaceResultDto> getRaceResult(final Cars cars) {
        List<RaceResultDto> raceResults = new ArrayList<>();
        for (int i = 0; i < raceCount.getCount(); i++) {
            RaceResultDto raceResult = RaceResultDto.of(cars.race());
            raceResults.add(raceResult);
        }
        return raceResults;
    }
}
