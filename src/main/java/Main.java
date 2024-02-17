import domain.RacingGame;
import domain.Round;
import error.ErrorHandler;
import view.InputView;

public class Main {

    public static void main(String[] args) {
        RacingGame racingGame = ErrorHandler.executeErrorOccurable(InputView::readCarNames);
        Round round = ErrorHandler.executeErrorOccurable(InputView::readRound);
        racingGame.play(round);
    }
}
