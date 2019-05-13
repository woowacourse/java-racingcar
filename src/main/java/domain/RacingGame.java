package domain;

import view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final RacingTrial racingTrial;
    private final MaxFinder maxFinder = new MaxFinder();

    public RacingGame(RacingTrial racingTrial) {
        this.racingTrial = racingTrial;
    }

    public void play(List<Car> cars, int nTrials) {
        OutputView.printMassage("실행결과");

        IntStream.range(0, nTrials).forEach((trial) -> OutputView.printCars(racingTrial.runTrial(cars)));

        OutputView.printWinners(maxFinder.findAllMax(cars, Car.positionComparator));
    }
}
