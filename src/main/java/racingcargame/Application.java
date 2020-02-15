package racingcargame;

import racingcargame.domain.game.CarRace;
import racingcargame.domain.result.CarRaceResult;
import racingcargame.domain.trialtimes.TrialTimes;
import racingcargame.parser.GameParser;
import racingcargame.view.intput.InputView;
import racingcargame.view.output.OutputView;

public class Application {
    public static void main(String[] args) {
        CarRace carRace = makeCarRace();
        TrialTimes trialTimes = makeTrialTimes();
        CarRaceResult carRaceResult = carRace.run(trialTimes);
        OutputView.printAllRoundResults(carRaceResult);
        OutputView.printWinners(carRaceResult);
    }

    private static CarRace makeCarRace() {
        try {
            return GameParser.generateCarRace(InputView.askCarNames());
        } catch (IllegalArgumentException iae) {
            OutputView.printError(iae);
            return makeCarRace();
        }

    }

    private static TrialTimes makeTrialTimes() {
        try {
            return GameParser.generateTrialTimes(InputView.askRound());
        } catch (IllegalArgumentException iae) {
            OutputView.printError(iae);
            return makeTrialTimes();
        }
    }
}
