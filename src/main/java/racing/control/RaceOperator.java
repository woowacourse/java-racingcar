package racing.control;

import racing.domain.Race;

import java.util.List;

public class RaceOperator {
    private static Race race;
    private static int numTrials;

    public RaceOperator(List<String> carNames, int numTrials) {
        race = new Race(carNames);
        this.numTrials = numTrials;
    }

    public Race doRace() {
        race.progressRace();
        numTrials--;
        return race;
    }

    public List<String> endRace() {
        return race.getResult();
    }

    public boolean isEnd() {
        if (numTrials > 0) return true;
        return false;
    }
}
