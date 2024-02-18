package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;
    private final RandomNumberUtil randomNumberUtil = new RandomNumberUtil();

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RaceResult> tryRace() {
        List<RaceResult> raceResults = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            racingCar.race(this.randomNumberUtil.generator());
            raceResults.add(new RaceResult(racingCar.getName(), racingCar.getMoveNumber()));
        }
        return raceResults;
    }

    public List<String> getWinners() {
        RacingCar winner = Collections.max(racingCars);

        return racingCars.stream()
                .filter(racingCar -> racingCar.hasSameDistance(winner))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
