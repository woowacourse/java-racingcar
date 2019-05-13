package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameResult {
    private List<String> racingCarResults;

    public GameResult() {
        this.racingCarResults = new ArrayList<>();
    }

    public void addResult(RacingCars racingCars) {
        racingCarResults.add(racingCars.getCurrentPositionsOfRacingCars());
    }

    public String getAllResults() {
        return String.join("\n\n", racingCarResults);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameResult that = (GameResult) o;
        return Objects.equals(racingCarResults, that.racingCarResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCarResults);
    }
}
