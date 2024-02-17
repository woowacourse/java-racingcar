import domain.Car;
import domain.RacingGame;
import domain.Round;
import error.ErrorHandler;
import java.util.List;
import view.InputView;
import view.OutputView;

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
