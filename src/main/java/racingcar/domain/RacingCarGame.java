package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<RacingCar> racingCars = new ArrayList<>();
    private AdvanceJudgement advanceJudgement;

    public RacingCarGame(AdvanceJudgement advanceJudgement) {
        this.advanceJudgement = advanceJudgement;
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public List<String> runRound() {
        List<String> roundResult = new ArrayList<>();
        racingCars.stream().forEach(racingCar -> {
            racingCar.advance(advanceJudgement.isAdvancePossible());
            roundResult.add(racingCar.getDesc());
        });
        return roundResult;
    }
}
