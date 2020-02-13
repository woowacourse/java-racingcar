package racingcargame;

import racingcargame.domain.CarRaceResult;
import racingcargame.domain.TrialTimes;
import racingcargame.game.CarRace;
import racingcargame.parser.GameParser;
import racingcargame.view.intput.InputView;
import racingcargame.view.output.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarRace carRace = GameParser.generateCarRace(InputView.askCarNames());
        TrialTimes trialTimes = GameParser.generateTrialTimes(InputView.askRound());
        CarRaceResult carRaceResult = carRace.run(trialTimes);
        OutputView.printEachTime(carRaceResult);
        List<String> winners = carRaceResult.getWinners();
        OutputView.printWinners(winners);
    }
}
