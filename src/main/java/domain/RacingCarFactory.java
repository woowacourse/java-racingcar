package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarFactory {
    public List<RacingCar> createBy(RacingCarNames racingCarNames) {
        return racingCarNames.getNames().stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }
}
