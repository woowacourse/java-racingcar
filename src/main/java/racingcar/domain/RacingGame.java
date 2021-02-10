package racingcar.domain;


import java.util.List;

public class RacingGame {
    private Cars cars;
    private Rounds rounds;

    public RacingGame(final Cars cars, final Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public boolean isEnd() {
        return rounds.isEnd();
    }

    public void race() {
        this.cars.tryMoveCars();
        this.rounds.next();
    }

    public List<RaceResultDTO> getRaceResults() {
        return cars.getResults();
    }

    public String[] getWinners() {
        return cars.getWinnerNames();
    }
}
