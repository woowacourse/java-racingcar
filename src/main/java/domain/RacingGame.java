package domain;

import view.OutputView;

import java.util.ArrayList;

public class RacingGame {
    private final RacingTrial racingTrial;

    public RacingGame(RacingTrial racingTrial) {
        this.racingTrial = racingTrial;
    }

    public void play(ArrayList<Car> cars, int nTrials) {
        for(int trial = 0; trial < nTrials; trial++) {
            racingTrial.runTrial();
        }

        ArrayList<Car> winners = new ArrayList();
        OutputView.printWinners(winners);
    }
}
