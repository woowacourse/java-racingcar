package racingcar.domain;

import java.util.Iterator;
import java.util.List;

public class Race implements Iterator {
    private final RaceStatus status;
    private int leftRounds;

    public Race(List<String> names, int numberOfTrials) {
        status = new RaceStatus(names, new RandomMovement());
        leftRounds = numberOfTrials;
    }

    @Override
    public RaceStatus next() {
        status.startEachRound();
        leftRounds--;
        return status;
    }

    public RaceStatus finish() {
        return status;
    }

    @Override
    public boolean hasNext() {
        return leftRounds != 0;
    }
}