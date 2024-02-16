package domain;

import view.OutputView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public void tryRace() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (RacingCar racingCar : racingCars) {
            racingCar.race(numberGenerator.generateNumber());
            printResult(racingCar);
        }

        System.out.println();
    }

    public List<String> getWinners() {
        Collections.sort(racingCars);
        RacingCar winner = racingCars.get(0);

        return racingCars.stream()
                .filter(racingCar -> racingCar.isSameDistance(winner))
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private void printResult(RacingCar racingCar) {
        OutputView.printResult(racingCar.getName(), racingCar.getMoveNumber());
    }
}
