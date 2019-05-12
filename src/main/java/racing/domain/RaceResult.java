package racing.domain;

import java.util.List;

public class RaceResult {
    private final List<Car> winners;

    public RaceResult(final List<Car> winners){
        this.winners = winners;
    }

    public List<Car> getWinners() { return winners; }
}
