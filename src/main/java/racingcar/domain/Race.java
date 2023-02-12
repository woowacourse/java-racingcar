package racingcar.domain;

import racingcar.domain.wrapper.RaceCount;

public class Race {

    private final RaceCount raceCount;

    private Race(final String raceCount) {
        this.raceCount = RaceCount.createRaceCount(raceCount);
    }

    public static Race createRace(final String raceCount) {
        return new Race(raceCount);
    }

    public boolean isRaceFinish(int raceCount) {
        return raceCount == this.raceCount.getCount();
    }
}
