package racingcargame;

import racingcargame.domain.Car;
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
        carRace.run(trialTimes);
        List<Car> winners = carRace.getWinners();
        OutputView.printWinners(winners);
    }
}
