package racingcar.domain;

import racingcar.domain.dto.RaceResultDto;
import racingcar.domain.wrapper.RaceCount;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final RaceCount raceCount;

    private Race(String raceCount) {
        this.raceCount = RaceCount.of(raceCount);
    }

    public static Race of(String tryCount) {
        return new Race(tryCount);
    }

    public List<RaceResultDto> start(Cars cars) {
        List<RaceResultDto> raceResults = new ArrayList<>();
        for (int i = 0; i < raceCount.getCount(); i++) {
            raceResults.add(RaceResultDto.of(cars.race()));
        }
        return raceResults;
    }
}
