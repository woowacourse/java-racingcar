package domain;

import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCars;
    private RandomNumberUtil randomNumberUtil = new RandomNumberUtil();

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
        Collections.sort(racingCars);
        RacingCar winner = racingCars.get(0);

        return racingCars.stream()
                .filter(racingCar -> racingCar.hasSameDistance(winner))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }
}
