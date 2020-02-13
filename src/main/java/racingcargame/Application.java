package racingcargame;

import racingcargame.domain.result.CarRaceResult;
import racingcargame.domain.trialtimes.TrialTimes;
import racingcargame.game.CarRace;
import racingcargame.parser.GameParser;
import racingcargame.view.intput.InputView;
import racingcargame.view.output.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarRace carRace = makeCarRace();
        TrialTimes trialTimes = makeTrialTimes();
        CarRaceResult carRaceResult = carRace.run(trialTimes);
        OutputView.printAllRounds(carRaceResult);
        List<String> winners = carRaceResult.getWinners();
        OutputView.printWinners(winners);
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
