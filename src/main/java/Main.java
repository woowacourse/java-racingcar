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

        RacingGame racingGame = errorHandler.executeErrorOccurable(inputView::readCarNames);
        Round round = errorHandler.executeErrorOccurable(inputView::readRound);

        System.out.println("실행 결과");
        for (int i = 0; i < round.getRound(); i++) {
            outputView.printScore(racingGame.playOneRound());
        }
        outputView.printCars(racingGame.findWinners());
    }
}
