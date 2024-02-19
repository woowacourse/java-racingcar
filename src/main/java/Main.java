import domain.RacingGame;
import domain.Round;
import error.ErrorHandler;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        ErrorHandler errorHandler = new ErrorHandler();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        RacingGame racingGame = errorHandler.readUntilNoExceptionOccurs(inputView::readCarNames);
        Round round = errorHandler.readUntilNoExceptionOccurs(inputView::readRound);

        outputView.printGameResult(racingGame, round);
    }
}
