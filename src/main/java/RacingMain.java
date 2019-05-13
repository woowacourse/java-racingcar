import domain.Race;
import view.InputView;
import view.OutputView;

/**
 * Main 클래스
 *
 * @author heebg
 * @version 1.0 2019-05-08
 */
public class RacingMain {
    public static void main(String[] args) {
        Race race = new Race(InputView.inputCarNames(), InputView.inputRoundCount());
        OutputView.outputGameResultTile();
        while (race.hasNextRound()) {
            race.moveAllCarOneTime();
            OutputView.outputGameResult(race.getRaceCarsInfo());
        }
        OutputView.outputWinners(race.winners().getWinnersName());
    }
}
