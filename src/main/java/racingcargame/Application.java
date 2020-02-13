package racingcargame;

import racingcargame.domain.TrialTimes;
import racingcargame.game.CarRace;
import racingcargame.parser.GameParser;
import racingcargame.view.intput.InputView;

public class Application {
    public static void main(String[] args) {
        CarRace carRace = GameParser.generateCarRace(InputView.askCarNames());
        TrialTimes trialTimes = GameParser.generateTrialTimes(InputView.askRound());
        carRace.run(trialTimes);
    }
}
