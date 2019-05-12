package domain;

import controller.RacingController;

import java.util.List;
import java.util.Objects;

public class Race {
    private List<Car> carsOnRace;
    private int roundCount;

    public Race(List<Car> carsOnRace, int roundCount) {
        this.carsOnRace = carsOnRace;
        this.roundCount = roundCount;
    }

    public List<Car> moveAllCarsByRoundCount() {
        for (int i = 0; i < roundCount; i++) {
            RacingController.hasNextRound(carsOnRace);
        }
        return carsOnRace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return roundCount == race.roundCount &&
                Objects.equals(carsOnRace, race.carsOnRace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsOnRace, roundCount);
    }
}
