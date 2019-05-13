package racing;

import racing.control.RaceOperator;

import racing.view.InputView;
import racing.view.OutputView;

public class RacingApplication {

    public static void main(String[] args) {
        RaceOperator raceOperator = new RaceOperator(InputView.inputCarNames(), InputView.inputNumTrials());
        while(raceOperator.isEnd()){
            OutputView.printProgress(raceOperator.doRace());
        }
        OutputView.printResult(raceOperator.endRace());
    }
}
