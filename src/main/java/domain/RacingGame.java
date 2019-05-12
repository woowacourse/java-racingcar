package domain;

import view.OutputView;

import java.util.ArrayList;

public class RacingGame {
    private final RacingTrial racingTrial;
    private final MaxFinder maxFinder = new MaxFinder();

    public RacingGame(RacingTrial racingTrial) {
        this.racingTrial = racingTrial;
    }

    public void play(ArrayList<Car> cars, int nTrials) {
        OutputView.printMassage("실행결과");

        for (int trial = 0; trial < nTrials; trial++) {
            OutputView.printCars(racingTrial.runTrial(cars));
        }

        OutputView.printWinners(maxFinder.findAllMax(cars, Car.positionComparator));
    }
}
