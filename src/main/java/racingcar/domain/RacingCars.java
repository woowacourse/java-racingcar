package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars of(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public static RacingCars generateByNames(List<String> racingCarNames) {
        return new RacingCars(racingCarNames.stream().map(racingCarName -> {
            return new RacingCar(racingCarName);
        }).collect(Collectors.toList()));
    }

    public void advanceCars(AdvanceJudgement advanceJudgement) {
        racingCars.forEach(racingCar -> {
            applyAdvanceJudgement(racingCar, advanceJudgement);
        });
    }

    private void applyAdvanceJudgement(RacingCar racingCar, AdvanceJudgement advanceJudgement) {
        if (advanceJudgement.isAdvancePossible()) {
            racingCar.advance();
        }
    }

    public List<String> getCurrentCarsDescription() {
        return racingCars.stream().map(RacingCar::getDesc).collect(Collectors.toList());
    }

    public RacingCar getFirstPositionCar() {
        return racingCars.stream().max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("레이싱카는 한 개 이상이어야 합니다."));
    }

    public List<String> getSamePositionCarNames(RacingCar targetCar) {
        return racingCars.stream().filter(racingCar -> {
            return racingCar.isSamePosition(targetCar);
        }).map(racingCar -> racingCar.getName()).collect(Collectors.toList());
    }
}
