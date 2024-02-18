package domain;

import dto.RaceResult;
import dto.RacingCarNames;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarMapper {
    public List<RacingCar> mapToRacingCars(final RacingCarNames racingCarNames) {
        return racingCarNames.getNames().stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public List<RaceResult> mapToResults(final List<RacingCar> triedRace) {
        return triedRace.stream()
                .map(racingCar -> new RaceResult(racingCar.getName(), racingCar.getMoveNumber()))
                .collect(Collectors.toList());
    }

    public List<String> mapToWinners(final List<RacingCar> winners) {
        return winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
