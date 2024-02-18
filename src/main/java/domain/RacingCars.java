package domain;

import dto.RaceResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> tryRace(final NumberGenerator numberGenerator) {
        racingCars.forEach(racingCar -> racingCar.race(numberGenerator.generateNumber()));
        return racingCars;
    }

    public List<RacingCar> getWinners() {
        Collections.sort(racingCars);
        RacingCar winner = racingCars.get(0);

        return racingCars.stream()
                .filter(racingCar -> racingCar.hasSameDistance(winner))
                .collect(Collectors.toList());
    }
}
