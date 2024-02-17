import domain.RacingGame;
import domain.Round;
import error.ErrorHandler;
import view.InputView;

public class Main {

    public static void main(String[] args) {
        try {
            RacingGame racingGame = ErrorHandler.executeErrorOccurable(InputView::readCarNames);
            Round round = ErrorHandler.executeErrorOccurable(InputView::readRound);
            racingGame.play(round);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
