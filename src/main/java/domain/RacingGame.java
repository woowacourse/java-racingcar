package domain;

import view.OutputView;

import java.util.ArrayList;

import static domain.MaxFinder.*;

public class RacingGame {
    private final RacingTrial racingTrial;

    public RacingGame(RacingTrial racingTrial) {
        this.racingTrial = racingTrial;
    }

    public void play(ArrayList<Car> cars, int nTrials) {
        OutputView.printMassage("실행결과");

        for (int trial = 0; trial < nTrials; trial++) {
            OutputView.printCars(racingTrial.runTrial(cars));
        }

        OutputView.printWinners(findAllMax(cars, Car.compareByPosition));
    }
}
