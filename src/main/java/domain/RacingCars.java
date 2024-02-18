package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RaceResult> tryRace(final NumberGenerator numberGenerator) {
        List<RaceResult> raceResults = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            racingCar.race(numberGenerator.generateNumber());
            raceResults.add(new RaceResult(racingCar.getName(), racingCar.getMoveNumber()));
        }
        return raceResults;
    }

    public List<String> getWinners() {
        Collections.sort(racingCars);
        RacingCar winner = racingCars.get(0);

        return racingCars.stream()
                .filter(racingCar -> racingCar.isSameDistance(winner))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
