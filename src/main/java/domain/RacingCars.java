package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(RacingCarFactory racingCarFactory) {
        this.racingCars = racingCarFactory.create();
    }

    public List<RaceResult> tryRace(NumberGenerator numberGenerator) {
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
