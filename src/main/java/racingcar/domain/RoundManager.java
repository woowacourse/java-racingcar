package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RacingCarDto;

public class RoundManager {
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final AdvanceJudgement advanceJudgement;

    public RoundManager(AdvanceJudgement advanceJudgement) {
        this.advanceJudgement = advanceJudgement;
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public List<String> getCurrentRound() {
        List<String> roundResult = new ArrayList<>();
        racingCars.stream().forEach(racingCar -> {
            roundResult.add(racingCar.getDesc());
        });
        return roundResult;
    }

    public List<String> runRound() {
        List<String> roundResult = new ArrayList<>();
        racingCars.forEach(racingCar -> {
            applyAdvanceJudgement(racingCar);
            roundResult.add(racingCar.getDesc());
        });
        return roundResult;
    }

    private void applyAdvanceJudgement(RacingCar racingCar){
        if(advanceJudgement.isAdvancePossible()){
            racingCar.advance();
        }
    }

    public List<RacingCarDto> getSortedRacingCars() {
        Collections.sort(racingCars);
        return racingCars.stream().map(RacingCar::toDto).collect(Collectors.toList());
    }
}
