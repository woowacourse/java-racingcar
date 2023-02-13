package racingcar.domain;

import racingcar.dto.RacingCarDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoundManager {
    private static final Boolean ALL_CARS_ADVANCE = true;
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final AdvanceJudgement advanceJudgement;

    public RoundManager(AdvanceJudgement advanceJudgement) {
        this.advanceJudgement = advanceJudgement;
    }

    public void addRacingCar(RacingCar racingCar) {
        racingCars.add(racingCar);
    }

    public List<RacingCarDto> getStartStatus() {
        List<RacingCarDto> roundResult = new ArrayList<>();
        racingCars.stream().forEach(racingCar -> {
            racingCar.advance(ALL_CARS_ADVANCE);
            roundResult.add(racingCar.toDto());
        });
        return roundResult;
    }

    public List<RacingCarDto> runRound() {
        List<RacingCarDto> roundResult = new ArrayList<>();
        racingCars.stream().forEach(racingCar -> {
            racingCar.advance(advanceJudgement.isAdvancePossible());
            roundResult.add(racingCar.toDto());
        });
        return roundResult;
    }

    public List<RacingCarDto> getSortedRacingCars() {
        Collections.sort(racingCars);
        return racingCars.stream().map(RacingCar::toDto).collect(Collectors.toList());
    }
}
