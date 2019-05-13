package racing.controller;

import racing.domain.Car;
import racing.domain.Race;

import java.util.List;

public class RacingGame {
    private final Race race;
    private int numTrials;

    public RacingGame(List<String> carNames, int numTrials) {
        race = new Race(carNames);
        this.numTrials = numTrials;
    }

    /* 자동차 경주 한 싸이클 진행 */
    public Race race() {
        race.progressRace();
        numTrials--;
        return race;
    }

    public List<Car> getResult() { return race.getWinners(); }

    public boolean isEnd() { return numTrials == 0; }
}
