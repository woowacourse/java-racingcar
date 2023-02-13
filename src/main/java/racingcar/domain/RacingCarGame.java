package racingcar.domain;

import java.util.List;

public class RacingCarGame {
    private final RacingCars racingCars;
    private final AdvanceJudgement advanceJudgement;

    public RacingCarGame(AdvanceJudgement advanceJudgement, RacingCars racingCars) {
        this.advanceJudgement = advanceJudgement;
        this.racingCars = racingCars;
    }

    public List<String> getCurrentState() {
        return racingCars.getCurrentCarsDescription();
    }

    public List<String> runRound() {
        racingCars.advanceCars(advanceJudgement);
        return getCurrentState();
    }

    public List<String> getWinnerNames() {
        RacingCar firstPositionCar = racingCars.getFirstPositionCar();
        return racingCars.getSamePositionCarNames(firstPositionCar);
    }
}
