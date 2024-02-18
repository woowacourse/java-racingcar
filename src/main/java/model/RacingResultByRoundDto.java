package model;

import java.util.List;

public class RacingResultByRoundDto {
    private final List<Car> resultByRound;

    public RacingResultByRoundDto(List<Car> resultByRound) {
        this.resultByRound = resultByRound;
    }

    public List<Car> getRacingResultByRound() {
        return this.resultByRound;
    }
}
