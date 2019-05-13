package racingcar.domain;

import java.util.Iterator;
import java.util.List;

public class Race implements Iterator {
    private final RaceStatus status;
    private int leftRound;

    public Race(List<String> names, int numberOfTrials) {
        status = new RaceStatus(names, new RandomMovement());
        leftRound = numberOfTrials;
    }

    public RaceStatus next() {
        status.startEachRound();
        leftRound--;
        return status;
    }

    public RaceStatus finish() {
        return status;
    }

    @Override
    public boolean hasNext() {
        return leftRound != 0;
    }
}